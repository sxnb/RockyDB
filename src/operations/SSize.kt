/**
 * Stack Size
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBStack
import RockyDB.GenericResult
import RockyDB.IResult

class SSize: AOperation {
    constructor (key: String): super(key) {
        this.operationType = OperationType.READ
    }

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (data[key]?.name !== "stack") {
            return GenericResult<Boolean>(false)
        }

        return (data[key] as RDBStack).size()
    }
}