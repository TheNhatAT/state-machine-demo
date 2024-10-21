package io.encapital.financing.cash.libstatemachine.domain

class ActiveStatus(
    private val savingsAccount: SavingsAccount,
    private val value: String = "active"
) : Status {
    override fun created() {
        throw IllegalStateException("Cannot change status from active to created")
    }

    override fun sent() {
        throw IllegalStateException("Cannot change status from active to sent")
    }

    override fun active() {
        savingsAccount.changeStatus(this)
    }

    override fun rejected() {
       throw IllegalStateException("Cannot change status from active to rejected")
    }

    override fun settled() {
        savingsAccount.changeStatus(SettleStatus(savingsAccount))
    }

    override fun value(): String {
        return value
    }
}