package com.bank.app

import android.app.Application
import com.bank.app.api.BankContracts
import com.bank.app.di.InteractorsModule
import com.bank.app.di.RepositoriesModule
import com.bank.app.di.api.ApiModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

class BankApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind() from instance(BankContracts.Server)
        //bind() from instance(BankContracts.Server.Valute)

        importOnce(androidXModule(this@BankApplication))
        importOnce(ApiModule.module)
        importOnce(RepositoriesModule.module)
        importOnce(InteractorsModule.module)
    }
}