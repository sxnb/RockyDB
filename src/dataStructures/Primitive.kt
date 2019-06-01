package dataStructures

import java.io.Serializable

class Primitive: IDataStructure, Serializable {
    var data: String = ""
    override var name: String = "primitive"

    constructor(data: String) {
        this.data = data
    }

    override fun serialize(): String {
        return data
    }
}