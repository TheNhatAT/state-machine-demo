package io.encapital.financing.cash.libstatemachine.domain

fun main() {
    val savingsAccountDP = SavingsAccount()

    println("Savings Account DP status: ${savingsAccountDP.status().value()}")
    savingsAccountDP.status().sent()
    println("Savings Account DP status: ${savingsAccountDP.status().value()}")
    savingsAccountDP.status().active()
    println("Savings Account DP status: ${savingsAccountDP.status().value()}")
    savingsAccountDP.status().settled()
    println("Savings Account DP status: ${savingsAccountDP.status().value()}")
}