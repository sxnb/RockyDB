import utils.generateUniqueId
import dataStructures.IDataStructure
import operations.IOperation
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import utils.e_log
import java.util.HashMap
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.net.ServerSocket

class RockyDB {
    var settings: Settings

    var data: HashMap<String, IDataStructure> = hashMapOf()
    var operationQueue: MutableList<IOperation> = mutableListOf()

    constructor(settings: Settings) {
        this.settings = settings
        this.continuousDumpThread()
        this.processLoop()
    }

    fun listen() {
        var t = Thread(Runnable {
            println("Listening for connections on ${this.settings.host}: ${this.settings.port}")
            val server = ServerSocket(this.settings.port)

            while (true) {
                val client = server.accept()
                ClientHandler(client).run(this)
            }
        })
        t.start()
    }

    /**
     *
     */
    fun processLoop() {
        var t = Thread(Runnable {
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

    /**
     *
     */
    fun continuousDumpThread() {
        if (!this.settings.dumpContinuously) {
            return
        }

        var t = Thread(Runnable {
            while(true) {
                this._dumpDb()
                Thread.sleep(10000)
            }
        })
        t.start()
    }

    /**
     *
     */
    fun enqueueOperation(operation: IOperation): String {
        val uid = generateUniqueId()
        operation.setOId(uid)
        this.operationQueue.add(operation)
        return uid
    }

    /**
     *
     */
    fun instant(operation: IOperation): IResult {
        return this._processOperation(operation)
    }

    /**
     *
     */
    private fun _processOperation(operation: IOperation): IResult {
        return operation.run(this.data)
    }

    /**
     *
     */
    private fun _dumpDb() {
        try {
            ObjectOutputStream(FileOutputStream(this.settings.dbFilePath)).use { os -> os.writeObject(this.data) }
        } catch(e: Exception) {
            e_log(e.toString())
        }
    }

    /**
     *
     */
    private fun _restoreDb() {
        try {
            ObjectInputStream(FileInputStream(this.settings?.dbFilePath)).use { x ->
                this.data = x.readObject() as HashMap<String, IDataStructure>
            }
        } catch(e: Exception) {
            e_log(e.toString())
        }
    }
}
