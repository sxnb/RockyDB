/**
 * Implementation of Flush
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import RockyDB.GenericResult
import RockyDB.IResult

class Flush: AOperation {
    constructor (): super() {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        data.clear()
        return GenericResult<Boolean>(true)
    }
}