package simpledomain

data class SavingsAccount(
    var status: SavingsAccountStatus = SavingsAccountStatus.CREATED
) {
    fun status(): String {
        return status.name
    }

    fun sent() {
        if (status != SavingsAccountStatus.CREATED) {
            throw IllegalStateException("Cannot change status from $status to SENT")
        }

        status = SavingsAccountStatus.SENT
    }

    fun active() {
        if (status != SavingsAccountStatus.SENT) {
            throw IllegalStateException("Cannot change status from $status to ACTIVE")
        }

        status = SavingsAccountStatus.ACTIVE
    }

    fun rejected() {
        if (status != SavingsAccountStatus.SENT) {
            throw IllegalStateException("Cannot change status from $status to REJECTED")
        }

        status = SavingsAccountStatus.REJECTED
    }

    fun settled() {
        if (status != SavingsAccountStatus.ACTIVE) {
            throw IllegalStateException("Cannot change status from $status to SETTLED")
        }

        status = SavingsAccountStatus.SETTLED
    }
}