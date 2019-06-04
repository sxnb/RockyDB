package dataStructures

interface IObserver {
    var subject: AObservable?
    fun update(e: Event)
}