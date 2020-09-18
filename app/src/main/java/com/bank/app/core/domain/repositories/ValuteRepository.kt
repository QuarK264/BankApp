package com.bank.app.core.domain.repositories

import com.bank.app.core.domain.entities.Valute
import io.reactivex.Single

interface ValuteRepository {
    fun getValutes(): Single<List<Valute>>
}