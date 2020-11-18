const commands = [
    'keys', 'pset', 'pupsert', 'pget', 'del', 'keys', 'dump', 'lcreate', 'ladd', 'ldel', 'lsize', 'qcreate', 'qenqueue', 'qdequeue', 'qpeek', 'qsize', 'qisempty', 'screate', 'spush', 'spop', 'speek', 'ssize', 'sisempty', 'ping', 'flush', 'type', 'exists', 'watch'
]

const filterCommands = (input) => {
    input = input ? input : "";
    input = input.split(" ")[0];
    return commands.filter((c) => c.indexOf(input.toLowerCase()) !== -1);
}

module.exports = { commands, filterCommands };