package com.bank.app.core.domain.interaction

import com.bank.app.core.base.Interactor
import com.bank.app.core.domain.entities.User
import com.bank.app.core.domain.repositories.UserRepository
import io.reactivex.Single

class GetUserInteractor(
    private val userRepository: UserRepository
) : Interactor<String, Single<User>> {

    override fun execute(request: String): Single<User> = userRepository
        .getUsers()
        .map { list ->
            list.single { it.cardNumber == request }
        }
}