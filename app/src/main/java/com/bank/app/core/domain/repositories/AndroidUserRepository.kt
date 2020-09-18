package com.bank.app.core.domain.repositories

import com.bank.app.api.UserApi
import com.bank.app.api.models.mapToDomain
import com.bank.app.core.domain.entities.User
import io.reactivex.Single

class AndroidUserRepository(
    private val userApi: UserApi
) : UserRepository {

    override fun getUsers(): Single<List<User>> = userApi
        .getUsers()
        .map { list ->
            list.map {
                it.mapToDomain()
            }
        }
}
