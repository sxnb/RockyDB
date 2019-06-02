package dataStructures

import RockyDB.IResult
import RockyDB.GenericResult
import java.io.Serializable

class RDBList: IDataStructure, Serializable {
    var data: MutableList<String> = mutableListOf()
    override var name: String = "list"

    constructor() {}

    fun add(item: String): IResult {
        this.data.add(item)

        return GenericResult<Int>(this.data.count())
    }

    fun remove(pos: Int): IResult {
        if (pos < 0) {
            return GenericResult<Boolean>(false)
        }

        if (pos >= this.data.count()) {
            return GenericResult<Boolean>(false)
        }

        this.data.removeAt(pos)
        return GenericResult<Boolean>(true)
    }

    fun size(): IResult {
        return GenericResult<Int>(this.data.count())
    }

    override fun serialize(): String {
        return this.data.toString()
    }
}