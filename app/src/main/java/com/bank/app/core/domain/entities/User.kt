package com.bank.app.core.domain.entities

import java.math.BigDecimal

data class User(
    val cardNumber: String,
    val type: String,
    val cardholderName: String,
    val valid: String,
    val balance: BigDecimal,
    val transactionHistory: List<Transaction>
)