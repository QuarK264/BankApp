package com.bank.app.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ListValute(
    @SerialName("GBP")
    val gbp: Valute,
    @SerialName("EUR")
    val eur: Valute
)
