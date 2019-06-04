package RockyDB

import java.lang.Exception
import java.util.*

class Settings {
    var host: String = "localhost"
    var port: Int = 4126
    var dbFilePath: String = "rdb1.rdb"
    var dumpContinuously: Boolean = true

    fun fromProperties(properties: Properties) {
        properties.forEach {
            when(it.key) {
                "host" -> { this.host = it.value.toString() }
                "port" -> { this.port = it.value.toString().toInt() }
                "dbFilePath" -> { this.dbFilePath = it.value.toString() }
                "dumpContinuously" -> { this.dumpContinuously = (if (it.value.toString().toLowerCase() == "true") true else false)}
                else -> throw Exception("Invalid setup parameter.")
            }
        }

    }
}