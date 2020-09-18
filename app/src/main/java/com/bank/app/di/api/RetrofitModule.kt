package com.bank.app.di.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.HttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.factory
import org.kodein.di.generic.instance
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object RetrofitModule {
    val module = Kodein.Module("Retrofit") {
        bind<Retrofit>() with factory { url: HttpUrl ->
            createRetrofit(
                instance(),
                url,
                instance()
            )
        }

        bind() from instance(
            Json(
                JsonConfiguration.Stable.copy(
                    prettyPrint = true,
                    ignoreUnknownKeys = true
                )
            )
        )
    }

    private fun createRetrofit(okHttpClient: OkHttpClient, baseUrl: HttpUrl, json: Json): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }
}