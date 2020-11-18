const yargs = require('yargs/yargs')
const {hideBin} = require('yargs/helpers')
const chalk = require('chalk');
const splash = require('./splash');
const inquirer = require('inquirer');

const RockyConnector = require('./connector');
const { commands } = require('./lib');

let connector;

//--------------------------------------------------------------------------

const log = (message) => {
    console.log(chalk.white(`[${(new Date()).toISOString()}] - ${message}`));
}

//--------------------------------------------------------------------------

const handleError = (message, shouldExit) => {
    console.log(chalk.red(message));

    if (shouldExit) {
        process.exit();
    }
}

//--------------------------------------------------------------------------

const connect = () => {
    const argv = yargs(hideBin(process.argv)).argv;
    if (!argv['port'] || !argv['host']) {
        return handleError('Either the --host or --port parameter is missing.', true);
    }

    log("Connecting...");

    return new Promise(async (resolve, reject) => {
        try {
            connector = new RockyConnector();
            await connector.connect(argv['host'], argv['port']);
            resolve();
        } catch (err) {
            reject(err);
        }
    });
}

//--------------------------------------------------------------------------

const handleCommand = async (c) => {
    let command = c.trim();

    command = command.split(' ');

    switch (command[0]) {
        case 'exit':
            connector.disconnect();
            process.exit(0);
            return;
        case 'help':
            console.log(JSON.stringify(commands));
            return;
        default:
            const reply = await connector.runLine(command.join(' '));
            console.log(reply);
    }
}

//--------------------------------------------------------------------------

const askForCommand = async () => {
    const answers = await inquirer.prompt([{
        type: 'input',
        message: '>',
        name: 'command',
    }]);

    const command = answers['command'];

    await handleCommand(command);
    await askForCommand();

}

//--------------------------------------------------------------------------

console.clear();
splash();
connect().then(() => {
    log("Connection successful.");
    askForCommand();
}).catch((err) => {
    handleError(err, true);
});

