package RockyDB

import dataStructures.IDataStructure
import dataStructures.IObserver
import operations.Watch
import utils.e_log
import java.io.OutputStream
import java.net.Socket
import java.nio.charset.Charset
import java.util.*

class ClientHandler {
    var client: Socket
    private var keyObserver: IObserver
    private var data: HashMap<String, IDataStructure> = hashMapOf()
    private val reader: Scanner
    private val writer: OutputStream
    private var running: Boolean = false
    private var dbRef: RockyDB? = null
    private var operationFactory: OperationFactory

    constructor(client: Socket) {
        this.client = client
        this.reader = Scanner(client.getInputStream())
        this.writer = client.getOutputStream()
        this.running = false

        this.operationFactory = OperationFactory()
        this.keyObserver = KeyObserver(this)
    }

    fun run(db: RockyDB) {
        this.dbRef = db
        this.running = true

        while (this.running) {
            try {
                val text = this.reader.nextLine()
                if (text == "exit") {
                    this._closeConnection()
                    continue
                }

                // parse command
                try {
                    var operation = this.operationFactory.create(text)

                    if (operation is Watch) {
                        ((this.dbRef as RockyDB).data[operation.key] as IDataStructure).attach(this.keyObserver)
                        this.running = false
                        continue
                    }

                    if (operation.isAsync()) {
                        this.writeToSocket(db.enqueueOperation(operation))
                    } else {
                        var operationResult = db.instant(operation)
                        this._handleOperationResult(operationResult)
                    }
                } catch (e: Exception) {
                    this.writeToSocket(e.toString())
                }

            } catch (ex: Exception) {
                try {
                    this.writeToSocket("EXCEPTION: " + ex.message + "\n")
                } catch (e: Exception) {
                    this._closeConnection()
                }
                this._closeConnection()
            } finally {

            }

        }
    }

    fun writeToSocket(message: String) {
        try {
            this.writer.write((message).toByteArray(Charset.defaultCharset()))
        } catch (ex: Exception) {
            e_log("Could not write to socket - connection lost.")
        }
    }

    private fun _handleOperationResult(result: IResult) {
        this.writeToSocket(result.serialize())
    }

    private fun _closeConnection() {
        this.running = false
        try {
            this.writeToSocket("Bye!\n")
        } catch (ex: Exception) {
            // do nothing
        }
        this.client.close()

    }
}