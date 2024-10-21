package io.encapital.financing.cash.libstatemachine.domain

class RejectedStatus(
    private val savingsAccount: SavingsAccount,
    private val value: String = "rejected"
) : Status {
    override fun created() {
        throw IllegalStateException("Cannot change status from rejected to created")
    }

    override fun sent() {
        throw IllegalStateException("Cannot change status from rejected to sent")
    }

    override fun active() {
        throw IllegalStateException("Cannot change status from rejected to active")
    }

    override fun rejected() {
        savingsAccount.changeStatus(this)
    }

    override fun settled() {
        throw IllegalStateException("Cannot change status from rejected to settled")
    }

    override fun value(): String {
        return value
    }
}