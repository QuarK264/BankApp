package com.bank.app.ui.details.model

import com.bank.app.core.domain.entities.Transaction as Domain

fun Domain.mapToView() = Transaction(title, iconUrl, date, amount)