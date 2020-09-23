package com.bank.app.ui.details.model

import java.math.BigDecimal

data class User(
    val cardNumber: String,
    val type: String,
    val cardholderName: String,
    val valid: String,
    val standardBalance: BigDecimal,
    val transactionHistory: List<Transaction>,
    var balance: BigDecimal = BigDecimal.ZERO
)