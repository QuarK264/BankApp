package com.bank.app.core.domain.entities

import android.net.Uri
import java.math.BigDecimal

data class Transaction(
    val title: String,
    val iconUrl: Uri,
    val date: String,
    val amount: BigDecimal
)
