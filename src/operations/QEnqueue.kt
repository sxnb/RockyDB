/**
 * Queue Enqueue
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBQueue
import RockyDB.GenericResult
import RockyDB.IResult

class QEnqueue: AOperation {
    constructor (key: String, value: String): super(key, value) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (data[key]?.name !== "queue") {
            return GenericResult<Boolean>(false)
        }

        return (data[key] as RDBQueue).enqueue(value)
    }
}