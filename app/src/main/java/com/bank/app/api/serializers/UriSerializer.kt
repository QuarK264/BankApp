package com.bank.app.api.serializers

import android.net.Uri
import kotlinx.serialization.*

@Serializer(Uri::class)
object UriSerializer : KSerializer<Uri> {
    override val descriptor : SerialDescriptor = SerialDescriptor("Uri")

    override fun deserialize(decoder : Decoder) : Uri {
        val uri = decoder.decodeString()

        return if (uri.isNotEmpty()) {
            Uri.parse(uri)
        } else {
            Uri.EMPTY
        }
    }

    override fun serialize(encoder : Encoder, value : Uri) {
        encoder.encodeString(value.toString())
    }
}