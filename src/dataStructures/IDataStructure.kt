package dataStructures

interface IDataStructure: IObservable {
    var name: String
    fun serialize(): String
}