package io.encapital.financing.cash.libstatemachine.domain

class CreatedStatus(
    private val savingsAccount: SavingsAccount,
    private val value: String = "created"
) : Status {
    override fun created() {
        savingsAccount.changeStatus(this)
    }

    override fun sent() {
       savingsAccount.changeStatus(SentStatus(savingsAccount))
    }

    override fun active() {
        throw IllegalStateException("Cannot change status from created to active")
    }

    override fun rejected() {
        throw IllegalStateException("Cannot change status from created to rejected")
    }

    override fun settled() {
        throw IllegalStateException("Cannot change status from created to settled")
    }

    override fun value(): String {
        return value
    }
}