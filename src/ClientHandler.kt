import java.io.OutputStream
import java.net.Socket
import java.nio.charset.Charset
import java.util.*

class ClientHandler {
    var client: Socket
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
        this._writeToSocket("Welcome to RockyDB 1.0.\n")
        this.operationFactory = OperationFactory()
    }

    fun run(db: RockyDB) {
        this.dbRef = db
        this.running = true

        while (this.running) {
            try {
                val text = this.reader.nextLine()
                if (text == "exit"){
                    this._closeConnection()
                    continue
                }

                // parse command
                try {
                    var operation = this.operationFactory.create(text)

                    if (operation.isAsync()) {
                        this._writeToSocket(db.enqueueOperation(operation))
                    } else {
                        var operationResult = db.instant(operation)
                        this._handleOperationResult(operationResult)
                    }
                } catch(e: Exception) {
                    this._writeToSocket(e.toString())
                }

            } catch (ex: Exception) {
                this._writeToSocket("EXCEPTION: " + ex.message + "\n")
                this._closeConnection()
            } finally {

            }

        }
    }

    private fun _handleOperationResult(result: IResult) {
        this._writeToSocket("AA: " + result.serialize())
    }

    private fun _writeToSocket(message: String) {
        this.writer.write((message).toByteArray(Charset.defaultCharset()))
    }

    private fun _closeConnection() {
        this.running = false
        this._writeToSocket("Bye!\n")
        this.client.close()

    }
}