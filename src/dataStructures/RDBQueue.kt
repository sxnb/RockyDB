package dataStructures

import RockyDB.IResult
import RockyDB.GenericResult
import java.io.Serializable

class RDBQueue: IDataStructure, Serializable {
    var data: MutableList<String> = mutableListOf()
    override var name: String = "queue"

    constructor() {}

    fun enqueue(item: String): IResult {
        this.data.add(item)

        return GenericResult<Int>(this.data.count())
    }

    fun dequeue(): IResult {
        if (this.data.isEmpty()) {
            return GenericResult<Boolean>(false)
        }

        return GenericResult<String>(this.data.removeAt(0))
    }

    fun peek(): IResult {
        if (this.data.isEmpty()){
            return GenericResult<Boolean>(false)
        } else {
            return GenericResult<String>(this.data[0])
        }
    }

    fun size(): IResult {
        return GenericResult<Int>(this.data.count())
    }

    fun isEmpty(): IResult {
        return GenericResult<Boolean>(this.data.isEmpty())
    }

    override fun serialize(): String {
        return this.data.toString()
    }
}