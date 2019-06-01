/**
 * Implementation of Keys
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import IResult
import java.io.FileOutputStream
import java.io.ObjectOutputStream

class Dump: AOperation {
    constructor (key: String): super(key) {}

    override fun run(data: HashMap<String, IDataStructure>): IResult {
        ObjectOutputStream(FileOutputStream(this.key)).use { os -> os.writeObject(data) }

        return GenericResult<Boolean>(true)
    }
}