package com.bank.app.core.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

abstract class BaseViewModel(application: Application) : AndroidViewModel(application),
    KodeinAware {
    private val parentKodein by kodein()

    open val dependencies: (Kodein.MainBuilder.() -> Unit)? = null

    override val kodein by Kodein.lazy {
        extend(parentKodein)

        dependencies?.invoke(this)
    }
}