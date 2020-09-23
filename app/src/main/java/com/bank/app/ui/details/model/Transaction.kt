package com.bank.app.ui.details.model

import android.net.Uri
import java.math.BigDecimal

data class Transaction(
    val title: String,
    val iconUrl: Uri,
    val date: String,
    val standardAmount: BigDecimal,
    var amount: BigDecimal = BigDecimal.ZERO
)