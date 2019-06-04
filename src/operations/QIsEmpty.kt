/**
 * Queue IsEmpty
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBQueue
import RockyDB.GenericResult
import RockyDB.IResult

class QIsEmpty: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (data[key]?.name !== "queue") {
            return GenericResult<Boolean>(false)
        }

        return (data[key] as RDBQueue).isEmpty()
    }
}