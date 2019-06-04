/**
 * Implementation of Watch
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import RockyDB.GenericResult
import RockyDB.IResult

class Watch: AOperation {
    constructor (key: String): super(key) {
        this.operationType = OperationType.READ
    }

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (!data.containsKey(key)) {
            return GenericResult<Int>(0)
        }

        return GenericResult<Int>(1)
    }
}