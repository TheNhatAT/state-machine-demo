package io.encapital.financing.cash.libstatemachine.domain

class SettleStatus(
    private val savingsAccount: SavingsAccount,
    private val value: String = "settled"
) : Status {
    override fun created() {
        throw IllegalStateException("Cannot change status from active to created")
    }

    override fun sent() {
        throw IllegalStateException("Cannot change status from active to sent")
    }

    override fun active() {
       throw IllegalStateException("Cannot change status from active to active")
    }

    override fun rejected() {
       throw IllegalStateException("Cannot change status from active to rejected")
    }

    override fun settled() {
        savingsAccount.changeStatus(this)
    }

    override fun value(): String {
        return value
    }
}