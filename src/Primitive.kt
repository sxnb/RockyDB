class Primitive: IDataStructure {
    var data: String = ""

    constructor(data: String) {
        this.data = data
    }

    override fun serialize(): String {
        return data
    }
}