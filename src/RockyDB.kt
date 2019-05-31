import utils.generateUniqueId
import dataStructures.IDataStructure
import operations.IOperation

class RockyDB {
    var host: String? = "localhost"
    var port: Int? = 4126

    var data: HashMap<String, IDataStructure> = hashMapOf()
    var operationQueue: MutableList<IOperation> = mutableListOf()

    constructor(host: String?, port: Int?) {
        if (host != null) {
            this.host = host
        }

        if (port != 0) {
            this.port = port
        }
    }

    fun listen() {
        var t = Thread(Runnable {
            println("Listening for connections on $host: $port")
            while(true) {
                while(this.operationQueue.count() > 0) {
                    var r = this._processOperation(this.operationQueue.removeAt(0))
                    r.toStdOut()
                }

                Thread.sleep(1000)
            }
        })
        t.start()
    }

    fun enqueueOperation(operation: IOperation): String {
        val uid = generateUniqueId()
        operation.setOId(uid)
        this.operationQueue.add(operation)
        return uid
    }

    fun instant(operation: IOperation): IResult {
        return this._processOperation(operation)
    }

    private fun _processOperation(operation: IOperation): IResult {
        return operation.run(this.data)
    }
}
