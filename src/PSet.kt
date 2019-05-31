class PSet(key: String, value: String): AOperation(key, value) {
    override fun run(data: HashMap<String, IDataStructure>): GenericResult<Boolean> {
        if (data.containsKey(key)) {
            return GenericResult(false)
        }

        data[key] = Primitive(value);
        return GenericResult(true)
    }
}