/**
 * Primitive Get
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.Primitive
import RockyDB.GenericResult
import RockyDB.IResult

class PGet: AOperation {
    constructor (key: String): super(key) {
        this.operationType = OperationType.READ
    }

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (!data.containsKey(key)) {
            return GenericResult<Boolean>(false)
        }

        if (!(data[key] is Primitive)) {
            return GenericResult<Boolean>(false)
        }

        return GenericResult<String?>((data[key] as Primitive).get())
    }
}