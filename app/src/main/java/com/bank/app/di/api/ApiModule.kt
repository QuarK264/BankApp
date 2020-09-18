package com.bank.app.di.api

import com.bank.app.api.BankContracts
import com.bank.app.api.UserApi
import com.bank.app.api.ValuteApi
import okhttp3.HttpUrl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

object ApiModule {
    val module = Kodein.Module("ApiModule") {
        importOnce(HttpClientModule.module)
        importOnce(RetrofitModule.module)

        bind() from singleton {
            instance<HttpUrl, Retrofit>(arg = instance<BankContracts.Server>().usersApi)
                .create(UserApi::class.java)
        }
        bind() from singleton {
            instance<HttpUrl, Retrofit>(arg = instance<BankContracts.Server>().valuteApi)
                .create(ValuteApi::class.java)
        }
    }
}