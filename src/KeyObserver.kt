package RockyDB

import dataStructures.*
import java.util.*

class KeyObserver: AObserver {
    var client: ClientHandler
    var data: HashMap<String, IDataStructure> = hashMapOf()
    override var subject: AObservable? = null

    constructor(client: ClientHandler) {
        this.client = client
    }

    override fun update(e: Event) {
        println("Updating here with event")
        this.client.writeToSocket(e.toString())
    }

}