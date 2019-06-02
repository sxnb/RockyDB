/**
 * List Delete Item
 * @author Sorin Banica
 */
package operations

import RockyDB.GenericResult
import dataStructures.IDataStructure
import RockyDB.IResult
import dataStructures.RDBList

class LDel: AOperation {
    constructor (key: String, value: String): super(key, value) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (data[key]?.name !== "list") {
            return GenericResult<Boolean>(false)
        }

        return (data[key] as RDBList).remove(value.toInt())
    }
}