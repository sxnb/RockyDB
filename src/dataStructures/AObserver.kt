package dataStructures

interface AObserver: IObserver {
    override var subject: AObservable?
    override fun update(e: Event)
}