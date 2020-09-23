package com.bank.app.core.domain.interaction

import com.bank.app.core.base.Interactor
import com.bank.app.core.domain.entities.Valute
import com.bank.app.core.domain.repositories.ValuteRepository
import io.reactivex.Single

class GetValutesInteractor(
    private val valuteRepository: ValuteRepository
) : Interactor<Unit, Single<List<Valute>>> {

    override fun execute(request: Unit): Single<List<Valute>> = valuteRepository.getValutes()
}