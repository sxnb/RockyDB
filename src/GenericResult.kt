class GenericResult<T>: IResult {
    private var data: T

    constructor(data: T) {
        this.data = data
    }

    override fun serialize(): String {
        return this.data.toString()
    }

    override fun toStdOut() {
        println(this.data.toString())
    }
}