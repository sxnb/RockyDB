/**
 * List Create
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBList
import RockyDB.GenericResult
import RockyDB.IResult

class LCreate: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        data[key] = RDBList()

        return GenericResult<Boolean>(true)
    }
}