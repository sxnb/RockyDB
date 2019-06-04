/**
 * Queue Create
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBQueue
import RockyDB.GenericResult
import RockyDB.IResult

class QCreate: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        data[key] = RDBQueue()

        return GenericResult<Boolean>(true)
    }
}