/**
 * Primitive Upsert
 * @author Sorin Banica
 */
package operations

import GenericResult
import dataStructures.IDataStructure
import dataStructures.Primitive

class PUpsert(key: String, value: String): AOperation(key, value) {
    override fun run(data: HashMap<String, IDataStructure>): GenericResult<Boolean> {
        data[key] = Primitive(value);
        return GenericResult(true)
    }
}