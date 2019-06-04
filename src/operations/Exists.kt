/**
 * Implementation of Exists
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import RockyDB.GenericResult
import RockyDB.IResult

class Exists: AOperation {
    constructor (key: String): super(key) {
        this.operationType = OperationType.READ
    }

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (!data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        return GenericResult<Boolean>(true)
    }
}