package com.bank.app.api.serializers

import kotlinx.serialization.*
import java.math.BigDecimal

@Serializer(BigDecimal::class)
object BigDecimalSerializer : KSerializer<BigDecimal> {
    override val descriptor = SerialDescriptor("BigDecimal")

    override fun deserialize(decoder: Decoder): BigDecimal {
        return BigDecimal(decoder.decodeDouble())
    }

    override fun serialize(encoder: Encoder, value: BigDecimal) {
        encoder.encodeDouble(value.toDouble())
    }
}