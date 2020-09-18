package com.bank.app.di

import com.bank.app.core.domain.repositories.AndroidUserRepository
import com.bank.app.core.domain.repositories.AndroidValuteRepository
import com.bank.app.core.domain.repositories.UserRepository
import com.bank.app.core.domain.repositories.ValuteRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.weakReference

object RepositoriesModule {
    val module = Kodein.Module("Repositories") {
        bind<UserRepository>() with singleton(weakReference) {
            AndroidUserRepository(instance())
        }
        bind<ValuteRepository>() with singleton(weakReference) {
            AndroidValuteRepository(instance())
        }
    }
}