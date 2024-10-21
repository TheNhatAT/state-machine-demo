package io.encapital.financing.cash.libstatemachine.domain

interface Status {
    fun created()
    fun sent()
    fun active()
    fun rejected()
    fun settled()
    fun value(): String
}