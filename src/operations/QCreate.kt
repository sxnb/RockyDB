/**
 * List Create
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import IResult
import dataStructures.Primitive
import dataStructures.RDBList
import dataStructures.RDBQueue

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