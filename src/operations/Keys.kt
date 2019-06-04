/**
 * Implementation of Keys
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import RockyDB.GenericResult
import RockyDB.IResult

class Keys: AOperation {
    constructor (): super() {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        return GenericResult<Set<String>>(data.keys)
    }
}