package nativedesignpattern

import nativedesignpattern.tinder.StateMachine


fun main() {
    val stateMachine = StateMachine.create<Status, Event, SideEffect> {
        initialState(Status.Created)

        state<Status.Created> {
            on<Event.onSent> {
                transitionTo(Status.Sent, SideEffect.Notify)
            }
        }

        state<Status.Sent> {
            on<Event.onRejected> {
                transitionTo(Status.Rejected, SideEffect.Notify)
            }
            on<Event.onActive> {
                transitionTo(Status.Active, SideEffect.Notify)
            }
        }

        state<Status.Active> {
            on<Event.onSettled> {
                transitionTo(Status.Settled, SideEffect.Notify)
            }
        }

        state<Status.Settled> {
            //do nothing
        }

        onTransition {
            println("Transition: $it")
        }
    }

    val savingsAccount = SavingsAccount(Status.Sent)

    // always need to create a state machine instance for each SavingsAccount object
    val nStateMachine = stateMachine.with {
        initialState(savingsAccount.status)
    }
    println(nStateMachine.state.value())

    nStateMachine.transition(Event.onSent)
    println(nStateMachine.state.value())

    nStateMachine.transition(Event.onActive)
    println(nStateMachine.state.value())

    nStateMachine.transition(Event.onSettled)
    println(nStateMachine.state.value())

    nStateMachine.transition(Event.onRejected)
    println(nStateMachine.state.value())
}

