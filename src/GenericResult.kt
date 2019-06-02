package RockyDB

class GenericResult<T>: IResult {
    private var data: T
    private var oid: String = ""

    constructor(data: T) {
        this.data = data
    }

    override fun setOId(id: String) {
        this.oid = id
    }

    override fun serialize(): String {
        return this.data.toString()
    }

    override fun toStdOut() {
        if (this.oid.isNotBlank()) {
            println(this.oid + ": " + this.data.toString())
            return
        }

        println(this.data.toString())
    }
}