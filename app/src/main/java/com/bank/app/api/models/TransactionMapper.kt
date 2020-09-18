package com.bank.app.api.models

import com.bank.app.core.domain.entities.Transaction as Domain

fun Transaction.mapToDomain() = Domain(title, iconUrl, date, amount)