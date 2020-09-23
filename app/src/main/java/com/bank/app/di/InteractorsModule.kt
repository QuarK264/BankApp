package com.bank.app.di

import com.bank.app.core.domain.interaction.GetSimpleUsersInteractor
import com.bank.app.core.domain.interaction.GetUserInteractor
import com.bank.app.core.domain.interaction.GetValutesInteractor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

object InteractorsModule {
    val module = Kodein.Module("Interactors") {
        bind() from provider {
            GetSimpleUsersInteractor(instance())
        }
        bind() from provider {
            GetUserInteractor(instance())
        }
        bind() from provider {
            GetValutesInteractor(instance())
        }
    }
}