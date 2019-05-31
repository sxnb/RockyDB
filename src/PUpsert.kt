class PUpsert(key: String, value: String): AOperation(key, value) {
    override fun run(data: HashMap<String, IDataStructure>): GenericResult<Boolean> {
        data[key] = Primitive(value);
        return GenericResult(true)
    }
}