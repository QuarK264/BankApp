package com.bank.app.api.models

import android.net.Uri
import com.bank.app.api.serializers.OffsetDateTimeSerializer
import com.bank.app.api.serializers.UriSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime

@Serializable
class ValuteMeta(
    @SerialName("Date")
    @Serializable(OffsetDateTimeSerializer::class)
    val date: OffsetDateTime,
    @SerialName("PreviousDate")
    @Serializable(OffsetDateTimeSerializer::class)
    val previousDate: OffsetDateTime,
    @SerialName("PreviousURL")
    @Serializable(UriSerializer::class)
    val previousURL: Uri,
    @SerialName("Timestamp")
    @Serializable(OffsetDateTimeSerializer::class)
    val timestamp: OffsetDateTime,
    @SerialName("Valute")
    val valute: List<Valute>
)