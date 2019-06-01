/**
 * List Create
 * @author Sorin Banica
 */
package operations

import GenericResult
import IResult
import dataStructures.*

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