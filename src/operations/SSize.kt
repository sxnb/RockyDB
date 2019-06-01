/**
 * Queue Size
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import IResult
import dataStructures.RDBList
import dataStructures.RDBQueue
import dataStructures.RDBStack

class SSize: AOperation {
    constructor (key: String): super(key) {}

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