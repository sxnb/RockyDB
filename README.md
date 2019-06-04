[![RockyDB](http://colorcode.me/assets/rockydb.png)](https://about.colorcode.me)

[![WorkInProgress](https://img.shields.io/static/v1.svg?label=&message=work%20in%20progress&color=informational)](https://about.colorcode.me)

### About

RockyDB is an in-memory storage engine which allows fast&easy storage of various data structures.
At the moment, RockyDB can store primitive data types, as well as Lists, Queues and Stacks.

### Features
 - supports Lists, Queues, Stacks
 - stored in-memory with automatic dump to file
 - allows manual dump and restoration from file
 - sync vs. async execution of commands
 - key event subscribe
 - JS Connector [https://github.com/sxnb/RockyDB-JS-connector](https://github.com/sxnb/RockyDB-JS-connector)

### In Progress

- implementation of Matrices, Trees
- PHP Connector

# Available Commands
Below you can find a table of all available commands. The commands are case insensitive.

| Command | Arguments | Example | Description |
| ------ | ------ | ------ | ------ |
| PSet | _key_ _value_ | **pset a 100** | Sets a primitive value to a key. Fails if the key already exists. |
| PUpsert | _key_ _value_ | **pupsert a 100** | Sets or updates a key. |
| PGet | _key_ | **pget a** | Retrieve a key containing a primitive value. |
| Del | _key_ | **del a** | Removes a key. |
| Keys | - | **keys** | Returns the list of all keys. |
| Dump | - | **dump** | Dumps the entire database to a file. |
| LCreate | _key_ | **lcreate mylist** | Initializes a list. |
| LAdd | _key_ _value_ | **ladd mylist myvalue** | Adds a value to the end of a list. |
| LDel | _key_ _value_ | **ldel mylist index** | Removes a value from a list. |
| LSize | _key_ | **lsize mylist** | Returns the size of a list. |
| QCreate | _key_ | **qcreate myqueue** | Initializes a queue. |
| QEnqueue | _key_ _value_ | **qenqueue myqueue myvalue** | Enqueues a value. |
| QDequeue | _key_ | **qdequeue myqueue** | Dequeues a value. |
| QPeek | _key_ | **qpeek myqueue** | Returns the head of a queue. |
| QSize | _key_ | **qsize myqueue** | Returns the size of a queue. |
| QIsEmpty | _key_ | **qisempty myqueue** | Returns whether a queue is empty. |
| SCreate | _key_ | **screate mystack** | Initializes a stack. |
| SPush | _key_ _value_ | **spush mystack myvalue** | Pushes a value to a stack. |
| SPop | _key_ | **spop mystack** | Pops a value from a stack. |
| SPeek | _key_ | **speek mystack** | Returns the top of a stack. |
| SSize | _key_ | **ssize mystack** | Returns the size of a stack. |
| SIsEmpty | _key_ | **sisempty mystack** | Returns whether a stack is empty. |
| Ping | - | **ping** | Pings the server. |
| Flush | - | **flush** | Removes all keys. |
| Type | _key_ | **type key** | Returns the type of a key. |
| Exists | _key_ | **exists key** | Returns whether a key exists. |
| Watch | _key_ | **watch key** | Gets notified when a key is modified. |

# TODO
| Command | Arguments | Example | Description |
| ------ | ------ | ------ | ------ |
| Increment | | | |
| Decrement | | | |
