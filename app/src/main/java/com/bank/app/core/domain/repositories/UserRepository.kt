package com.bank.app.core.domain.repositories

import com.bank.app.core.domain.entities.User
import io.reactivex.Single

interface UserRepository {
    fun getUsers(): Single<List<User>>
}