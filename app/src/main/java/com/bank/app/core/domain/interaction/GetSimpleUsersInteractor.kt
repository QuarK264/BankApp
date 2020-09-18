package com.bank.app.core.domain.interaction

import com.bank.app.core.base.Interactor
import com.bank.app.core.domain.entities.SimpleUser
import com.bank.app.core.domain.repositories.UserRepository
import io.reactivex.Single

class GetSimpleUsersInteractor(
    private val userRepository: UserRepository
) : Interactor<Unit, Single<List<SimpleUser>>> {

    override fun execute(request: Unit): Single<List<SimpleUser>> = userRepository
        .getUsers()
        .map { list ->
            list.map {
                with(it) {
                    SimpleUser(cardNumber, type, cardholderName, valid, balance)
                }
            }
        }
}