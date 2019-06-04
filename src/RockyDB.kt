package RockyDB

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.util.HashMap
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.net.ServerSocket
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import dataStructures.IDataStructure
import operations.IOperation
import operations.OperationType
import utils.generateUniqueId
import utils.e_log
import java.net.InetAddress

/**
 * This is the main class of RockyDB. It handles the management of threads as well as the
 * execution of operations.
 */
class RockyDB {
    var settings: Settings

    var data: HashMap<String, IDataStructure> = hashMapOf()
    var operationQueue: MutableList<IOperation> = mutableListOf()
    var clients: MutableList<Thread> = mutableListOf()
    var dataLock: ReentrantLock = ReentrantLock()

    constructor(settings: Settings) {
        this.settings = settings
        this.continuousDumpThread()
        this.processLoop()
        this.clientsLoop()
    }

    fun listen() {
        var t = Thread(Runnable {
            println("Listening for connections on ${this.settings.host}:${this.settings.port}")
            val server = ServerSocket(this.settings.port, 0, InetAddress.getByName(this.settings.host))

            while (true) {
                val client = server.accept()

                var t = Thread(Runnable {
                    val clientHandler = ClientHandler(client)
                    clientHandler.run(this)
                })
                this.clients.add(t)
                this.clients.last().start()

            }
        })
        t.start()
    }

    /**
     *
     */
    fun clientsLoop() {
        // TODO remove hanging threads
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
     * Processes an operation.
     */
    private fun _processOperation(operation: IOperation): IResult {
        var result: IResult = GenericResult<Boolean>(false)

        if (operation.operationType === OperationType.WRITE) {
            this.dataLock.withLock {
                result = operation.run(this.data)
            }
        } else {
            result = operation.run(this.data)
        }

        return result
    }

     /**
     *
     */
    private fun _dumpDb() {
        try {
            ObjectOutputStream(FileOutputStream(System.getProperty("user.dir") + "\\" + this.settings.dbFilePath)).use { os -> os.writeObject(this.data) }
        } catch(e: Exception) {
            e_log(e.toString())
        }
    }

    /**
     *
     */
    private fun _restoreDb() {
        try {
            ObjectInputStream(FileInputStream(System.getProperty("user.dir") + "\\" + this.settings?.dbFilePath)).use { x ->
                this.data = x.readObject() as HashMap<String, IDataStructure>
            }
        } catch(e: Exception) {
            e_log(e.toString())
        }
    }
}
