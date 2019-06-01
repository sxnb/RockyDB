/**
 * Operation Interface
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import IResult

interface IOperation {
    fun run(data: HashMap<String, IDataStructure>): IResult
    fun setOId(id: String)
}