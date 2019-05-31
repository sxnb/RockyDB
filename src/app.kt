import operations.PGet
import operations.PSet
import operations.PUpsert

fun main(args: Array<String>) {
    var rdb = RockyDB("localhost", 4126)
    rdb.listen()

    var o1 = PSet("100", "500")
    var o2 = PGet("100")
    var o3 = PSet("100", "200")
    var o4 = PGet("100")
    var o5 = PUpsert("100", "200")
    var o6 = PGet("100")
    rdb.enqueueOperation(o1)
    rdb.enqueueOperation(o2)
    rdb.enqueueOperation(o3)
    rdb.enqueueOperation(o4)
    rdb.enqueueOperation(o5)
    rdb.enqueueOperation(o6)
}
