package com.bank.app.ui.details.model

import com.bank.app.core.domain.entities.User as Domain

fun Domain.mapToView() = User(
    cardNumber,
    type,
    cardholderName,
    valid,
    balance,
    transactionHistory.map { it.mapToView() }
)