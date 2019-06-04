/**
 * Implementation of Keys
 * @author Sorin Banica
 */
package operations

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import dataStructures.IDataStructure
import RockyDB.GenericResult
import RockyDB.IResult

class Dump: AOperation {
    constructor (key: String): super(key) {
        this.operationType = OperationType.READ
    }

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        ObjectOutputStream(FileOutputStream(this.key)).use { os -> os.writeObject(data) }

        return GenericResult<Boolean>(true)
    }
}