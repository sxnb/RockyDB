/**
 * Operation Interface
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import RockyDB.IResult

interface IOperation {
    var operationType: OperationType
    fun run(data: HashMap<String, IDataStructure>): IResult
    fun setOId(id: String)
}