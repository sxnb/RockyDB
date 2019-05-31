/**
 * Implementation of Keys
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import IResult

class Keys: AOperation {
    constructor (): super() {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        return GenericResult<Set<String>>(data.keys)
    }
}