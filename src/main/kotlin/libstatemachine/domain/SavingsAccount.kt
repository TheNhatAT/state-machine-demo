package io.encapital.financing.cash.libstatemachine.domain

class SavingsAccount {
    private var status: Status

    init {
        status = CreatedStatus(this)
    }

    fun changeStatus(status: Status) {
        this.status = status
    }

    fun status(): Status {
        return status
    }
}