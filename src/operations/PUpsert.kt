/**
 * Primitive Upsert
 * @author Sorin Banica
 */
package operations

import dataStructures.IDataStructure
import dataStructures.Primitive
import RockyDB.GenericResult

class PUpsert(key: String, value: String): AOperation(key, value) {
    override fun run(data: HashMap<String, IDataStructure>): GenericResult<Boolean> {
        if (data.containsKey(key)) {
            (data[key] as Primitive).set(value)
            return GenericResult(true)
        }

        data[key] = Primitive();
        (data[key] as Primitive).set(value)

        return GenericResult(true)
    }
}