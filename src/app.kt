package RockyDB.rdb

import RockyDB.Settings
import RockyDB.RockyDB
import operations.Keys
import operations.PGet
import operations.PSet
import operations.PUpsert

fun main(args: Array<String>) {
    println(args.toString())
    var settings = Settings()
    var rdb = RockyDB(settings)
    rdb.listen()

    var o1 = PSet("a", "500")
    var o2 = PGet("a")
    var o3 = PSet("a", "200")
    var o4 = PGet("a")
    var o5 = PUpsert("b", "200")
    var o6 = PGet("b")
    rdb.enqueueOperation(o1)
    rdb.enqueueOperation(o2)
    rdb.enqueueOperation(o3)
    rdb.enqueueOperation(o4)
    rdb.enqueueOperation(o5)
    rdb.enqueueOperation(o6)

    rdb.enqueueOperation(Keys())
}
