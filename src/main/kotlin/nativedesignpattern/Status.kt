package nativedesignpattern

sealed class Status {
    object Created : Status()
    object Sent : Status()
    object Rejected : Status()
    object Active : Status()
    object Settled : Status()

    fun value(): String {
        return when (this) {
            is Created -> "Created"
            is Sent -> "Sent"
            is Rejected -> "Rejected"
            is Active -> "Active"
            is Settled -> "Settled"
        }
    }
}

sealed class Event {
    object onSent : Event()
    object onRejected : Event()
    object onActive : Event()
    object onSettled : Event()
}

sealed class SideEffect {
    object None : SideEffect()
    object Notify : SideEffect()
}