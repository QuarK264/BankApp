package com.bank.app.api.models

import android.net.Uri
import com.bank.app.api.serializers.BigDecimalSerializer
import com.bank.app.api.serializers.UriSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
class Transaction(
    val title: String,
    @SerialName("icon_url")
    @Serializable(UriSerializer::class)
    val iconUrl: Uri,
    val date: String,
    @Serializable(BigDecimalSerializer::class)
    val amount: BigDecimal
)