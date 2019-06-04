package dataStructures

interface IObservable {
    var observers: MutableList<IObserver>
    fun attach(observer: IObserver)
    fun notifyObservers(e: Event)
}