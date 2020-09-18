package com.bank.app.api.models

import com.bank.app.api.serializers.BigDecimalSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
class Valute(
    @SerialName("ID")
    val id: String,
    @SerialName("NumCode")
    val numCode: String,
    @SerialName("CharCode")
    val charCode: String,
    @SerialName("Nominal")
    val nominal: Int,
    @SerialName("Name")
    val name: String,
    @SerialName("Value")
    @Serializable(BigDecimalSerializer::class)
    val value: BigDecimal,
    @SerialName("Previous")
    @Serializable(BigDecimalSerializer::class)
    val previous: BigDecimal
)
