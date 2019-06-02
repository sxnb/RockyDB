package RockyDB

import operations.*
import java.lang.Exception

class OperationFactory {

    fun create(text: String): AOperation {
        var text = text.trim()
        var values: Array<String> = text.split(" ").toTypedArray()
        if (values.count() > 3) {
            var mergedValue: String = ""
            for (i in 2 until values.count()) {
                if (values[i] !== "async") {
                    mergedValue += values[i] + " "
                }
            }

            mergedValue = mergedValue.trim()

            if (values.last().toLowerCase() === "async") {
                values[2] = mergedValue
                values[3] = "async"
            } else {
                values[2] = mergedValue
            }
        }

        values[0] = values[0].toLowerCase()

        var minValues = when(values[0]) {
            "del" -> 2
            "dump" -> 2
            "keys" -> 1
            "ladd" -> 3
            "lcreate" -> 2
            "ldel" -> 3
            "lsize" -> 2
            "pget" -> 2
            "pset" -> 3
            "pupsert" -> 3
            "qcreate" -> 2
            "qdequeue" -> 2
            "qenqueue" -> 3
            "qisempty" -> 2
            "qpeek" -> 2
            "qsize" -> 2
            "screate" -> 2
            "sisempty" -> 2
            "speek" -> 2
            "ssize" -> 2
            "spop" -> 2
            "spush" -> 3
            else -> throw Exception("Invalid operation.")
        }

        if (values.count() < minValues) {
            throw Exception("Invalid number of parameters.")
        }

        var op: AOperation
        when(values[0]) {
            "del" -> op = Del(values[1])
            "dump" -> op = Dump(values[1])
            "keys" -> op = Keys()
            "ladd" -> op = LAdd(values[1], values[2])
            "lcreate" -> op = LCreate(values[1])
            "ldel" -> op = LDel(values[1], values[2])
            "lsize" -> op = LSize(values[1])
            "pget" -> op = PGet(values[1])
            "pset" -> op = PSet(values[1], values[2])
            "pupsert" -> op = PUpsert(values[1], values[2])
            "qcreate" -> op = QCreate(values[1])
            "qdequeue" -> op = QDequeue(values[1])
            "qenqueue" -> op = QEnqueue(values[1], values[2])
            "qisempty" -> op = QIsEmpty(values[1])
            "qpeek" -> op = QPeek(values[1])
            "qsize" -> op = QSize(values[1])
            "screate" -> op = SCreate(values[1])
            "sisempty" -> op = SIsEmpty(values[1])
            "speek" -> op = SPeek(values[1])
            "ssize" -> op = SSize(values[1])
            "spop" -> op = SPop(values[1])
            "spush" -> op = SPush(values[1], values[2])
            else -> throw Exception("Invalid operation.")
        }


        return op
    }
}