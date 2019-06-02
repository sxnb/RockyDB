package RockyDB

interface IResult {
    fun setOId(id: String)
    fun serialize(): String
    fun toStdOut()
}