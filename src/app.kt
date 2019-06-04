package RockyDB.rdb

import java.io.FileReader
import java.util.*
import RockyDB.Settings
import RockyDB.RockyDB

fun main(args: Array<String>) {
    val properties = Properties()
    val propertiesFile = System.getProperty("user.dir") + "\\rockydb.properties"
    val reader = FileReader(propertiesFile)
    properties.load(reader)

    var settings = Settings()
    settings.fromProperties(properties)

    var rdb = RockyDB(settings)
    rdb.listen()
}
