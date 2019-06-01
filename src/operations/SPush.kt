/**
 * Queue Enqueue
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import IResult
import dataStructures.RDBList
import dataStructures.RDBQueue
import dataStructures.RDBStack

class SPush: AOperation {
    constructor (key: String, value: String): super(key, value) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (data[key]?.name !== "stack") {
            return GenericResult<Boolean>(false)
        }

        return (data[key] as RDBStack).push(value)
    }
}