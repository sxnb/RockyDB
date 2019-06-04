/**
 * Primitive Set
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.Primitive
import RockyDB.GenericResult

class PSet(key: String, value: String): AOperation(key, value) {
    override fun run(data: HashMap<String, IDataStructure>): GenericResult<Boolean> {
        if (data.containsKey(key)) {
            return GenericResult(false)
        }

        data[key] = Primitive()
        (data[key] as Primitive).set(value)
        return GenericResult(true)
    }
}