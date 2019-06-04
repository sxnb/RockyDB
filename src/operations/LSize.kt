/**
 * List Size
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.RDBList
import RockyDB.GenericResult
import RockyDB.IResult

class LSize: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (data[key]?.name !== "list") {
            return GenericResult<Boolean>(false)
        }

        return (data[key] as RDBList).size()
    }
}