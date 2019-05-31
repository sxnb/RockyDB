/**
 * Implementation of Delete
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import IResult

class Del: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (!data.containsKey(key)) {
            return GenericResult<Int>(0)
        }

        data.remove(key)
        return GenericResult<Int>(1)
    }
}