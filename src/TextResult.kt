class TextResult: IResult {

    var data: String = ""

    override fun setOId(id: String) {}

    override fun serialize(): String {
        return data
    }

    override fun toStdOut() {
        println(data)
    }
}