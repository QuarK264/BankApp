package com.bank.app.api.models

import com.bank.app.api.serializers.BigDecimalSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
class User(
    @SerialName("card_number")
    val cardNumber: String,
    val type: String,
    @SerialName("cardholder_name")
    val cardholderName: String,
    val valid: String,
    @Serializable(BigDecimalSerializer::class)
    val balance: BigDecimal,
    @SerialName("transaction_history")
    val transactionHistory: List<Transaction>
)