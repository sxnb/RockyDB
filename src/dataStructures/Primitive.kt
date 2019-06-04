package dataStructures

import java.io.Serializable

class Primitive: IDataStructure, Serializable, AObservable {
    var data: String = ""
    override var name: String = "primitive"

    constructor() {}

    fun set(data: String) {
        this.data = data
        this.notifyObservers(Event.UPDATED)
    }

    fun get(): String {
        return this.data
    }

    fun del() {
        this.notifyObservers(Event.DELETED)
    }

    override fun serialize(): String {
        return data
    }
}