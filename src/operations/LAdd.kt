/**
 * List Add
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBList
import RockyDB.GenericResult
import RockyDB.IResult

class LAdd: AOperation {
    constructor (key: String, value: String): super(key, value) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (data[key]?.name !== "list") {
            return GenericResult<Boolean>(false)
        }

        return (data[key] as RDBList).add(value)
    }
}