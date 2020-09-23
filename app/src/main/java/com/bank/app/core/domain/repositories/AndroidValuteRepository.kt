package com.bank.app.core.domain.repositories

import com.bank.app.api.ValuteApi
import com.bank.app.api.models.mapToDomain
import com.bank.app.core.domain.entities.Valute
import io.reactivex.Single

class AndroidValuteRepository(
    private val valuteApi: ValuteApi
) : ValuteRepository {

    override fun getValutes(): Single<List<Valute>> = valuteApi
        .getValutes()
        .map { meta ->
            listOf(
                meta.valute.gbp.mapToDomain(),
                meta.valute.eur.mapToDomain()
            )
        }
}
