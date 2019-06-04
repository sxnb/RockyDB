/**
 * Implementation of Type
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import RockyDB.GenericResult
import RockyDB.IResult

class Type: AOperation {
    constructor (key: String): super(key) {
        this.operationType = OperationType.READ
    }

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        if (!data.containsKey(key)) {
            return GenericResult<String>("no-key")
        }

        return GenericResult<String>((data[key] as IDataStructure).name)
    }
}