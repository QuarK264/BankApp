package com.bank.app.core.base

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

abstract class BaseActivity : RxAppCompatActivity(), KodeinAware {
    private val parentKodein by org.kodein.di.android.kodein()

    open val dependencies: (Kodein.MainBuilder.() -> Unit)? = null

    override val kodein by Kodein.lazy {
        extend(parentKodein)

        dependencies?.invoke(this)
    }
}