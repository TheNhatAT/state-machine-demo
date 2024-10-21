package io.encapital.financing.cash.libstatemachine.domain

class SentStatus(
    private val savingsAccount: SavingsAccount,
    private val value: String = "sent"
) : Status {
    override fun created() {
        throw IllegalStateException("Cannot change status from sent to created")
    }

    override fun sent() {
        savingsAccount.changeStatus(this)
    }

    override fun active() {
        savingsAccount.changeStatus(ActiveStatus(savingsAccount))
    }

    override fun rejected() {
        savingsAccount.changeStatus(RejectedStatus(savingsAccount))
    }

    override fun settled() {
        throw IllegalStateException("Cannot change status from sent to settled")
    }

    override fun value(): String {
        return value
    }
}