/**
 * Abstract Operation
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import IResult

abstract class AOperation: IOperation {
    var key: String = ""
    var value: String = ""
    var oid: String = ""

    constructor(key: String, value: String) {
        this.key = key
        this.value = value
    }

    constructor(key: String) {
        this.key = key
    }

    constructor() {}

    override fun setOId(id: String) {
        this.oid = id
    }

    abstract override fun run(data: HashMap<String, IDataStructure>): IResult
}