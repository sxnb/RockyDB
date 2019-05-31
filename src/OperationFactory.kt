import operations.AOperation
import operations.PGet

class OperationFactory {

    fun create(): AOperation {
        //todo
        return PGet("a")
    }
}