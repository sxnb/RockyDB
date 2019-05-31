class TextResult: IResult {

    var data: String = ""

    override fun serialize(): String {
        return data
    }

    override fun toStdOut() {
        println(data)
    }
}