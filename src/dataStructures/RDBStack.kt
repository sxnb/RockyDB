package dataStructures

import java.io.Serializable
import RockyDB.IResult
import RockyDB.GenericResult

class RDBStack: IDataStructure, Serializable, AObservable {
    var data: MutableList<String> = mutableListOf()
    override var name: String = "stack"

    constructor() {}

    fun push(item: String): IResult {
        this.data.add(item)

        this.notifyObservers(Event.UPDATED)
        return GenericResult<Int>(this.data.count())
    }

    fun pop(): IResult {
        if (this.data.isEmpty()) {
            return GenericResult<Boolean>(false)
        }

        this.notifyObservers(Event.DELETED)
        return GenericResult<String>(this.data.removeAt(this.data.count() - 1))
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