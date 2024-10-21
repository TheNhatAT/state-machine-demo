package nativedesignpattern

data class SavingsAccount(
    val status: Status,
) {
    fun status(): String {
        return status.value()
    }
}