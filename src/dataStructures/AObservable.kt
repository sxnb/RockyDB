package dataStructures

abstract class AObservable: IObservable {
    override var observers: MutableList<IObserver> = mutableListOf()

    override fun attach(observer: IObserver) {
        this.observers.add(observer)
    }

    override fun notifyObservers(e: Event) {
        for (i in 0 until this.observers.count()) {
            this.observers[i].update(e)
        }
    }
}