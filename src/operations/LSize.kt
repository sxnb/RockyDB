/**
 * List Size
 * @author Sorin Banica
 */
package operations

import RockyDB.GenericResult
import dataStructures.IDataStructure
import RockyDB.IResult
import dataStructures.RDBList

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