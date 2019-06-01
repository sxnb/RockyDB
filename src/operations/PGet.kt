/**
 * Primitive Get
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import IResult
import dataStructures.Primitive

class PGet: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (!data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (!(data[key] is Primitive)) {
            return GenericResult<Boolean>(false)
        }

        return GenericResult<String?>(data[key]?.serialize())
    }
}