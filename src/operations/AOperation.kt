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
    private var async: Boolean = false

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

    fun makeAsync() {
        this.async = true
    }

    fun isAsync(): Boolean {
        return this.async
    }

    abstract override fun run(data: HashMap<String, IDataStructure>): IResult
}