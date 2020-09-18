package com.bank.app.api.models

import com.bank.app.core.domain.entities.Valute as Domain

fun Valute.mapToDomain() = Domain(id, numCode, charCode, nominal, name, value, previous)