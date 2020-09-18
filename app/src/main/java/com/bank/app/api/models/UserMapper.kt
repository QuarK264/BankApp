package com.bank.app.api.models

import com.bank.app.core.domain.entities.User as Domain

fun User.mapToDomain() = Domain(
    cardNumber,
    type,
    cardholderName,
    valid,
    balance,
    transactionHistory.map { it.mapToDomain() }
)