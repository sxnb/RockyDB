const chalk = require("chalk");

module.exports = () => {
  const lines = [
   " _____            _          _____  ____",
   "|  __ \\          | |        |  __ \\|  _ \\",
   "| |__) |___   ___| | ___   _| |  | | |_) |",
   "|  _  // _ \\ / __| |/ / | | | |  | |  _ <",
   "| | \\ \\ (_) | (__|   <| |_| | |__| | |_) |",
   "|_|  \\_\\___/ \\___|_|\\_\\\\__, |_____/|____/",
   "                        __/ |",
  ]

  for (let i = 0; i < lines.length; i++) {
    console.log(chalk.red(lines[i]));
  }

  console.log(chalk.white(" RockyDB Client 1.0.0  ") + chalk.red("|___/\n\n"));
};