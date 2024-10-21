package simpledomain

fun main() {
    val savingsAccountDP = SavingsAccount()

    println("Savings Account DP status: ${savingsAccountDP.status()}")
    savingsAccountDP.sent()
    println("Savings Account DP status: ${savingsAccountDP.status()}")
    savingsAccountDP.active()
    println("Savings Account DP status: ${savingsAccountDP.status()}")
    savingsAccountDP.settled()
    println("Savings Account DP status: ${savingsAccountDP.status()}")
    savingsAccountDP.rejected()
}