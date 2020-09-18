package com.bank.app.api

import com.bank.app.api.models.ValuteMeta
import io.reactivex.Single
import retrofit2.http.GET

interface ValuteApi {

    @GET("daily_json.js")
    fun getValutes(): Single<ValuteMeta>
}
