package com.bank.app.api

import com.bank.app.api.models.UserWrapper
import io.reactivex.Single
import retrofit2.http.GET

interface UserApi {

    @GET("users.json")
    fun getUsers(): Single<UserWrapper>
}