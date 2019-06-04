/**
 * Stack Create
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBStack
import RockyDB.GenericResult
import RockyDB.IResult

class SCreate: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        data[key] = RDBStack()

        return GenericResult<Boolean>(true)
    }
}