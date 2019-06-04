/**
 * Implementation of Ping
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import RockyDB.GenericResult
import RockyDB.IResult

class Ping: AOperation {
    constructor (): super() {
        this.operationType = OperationType.READ
    }

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        return GenericResult<String>("PONG")
    }
}