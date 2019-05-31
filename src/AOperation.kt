abstract class AOperation: IOperation {
    var key: String = ""
    var value: String = ""

    constructor(key: String, value: String) {
        this.key = key
        this.value = value
    }

    constructor(key: String) {
        this.key = key
    }

    abstract override fun run(data: HashMap<String, IDataStructure>): IResult
}