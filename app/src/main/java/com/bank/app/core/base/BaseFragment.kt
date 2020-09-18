package com.bank.app.core.base

import com.trello.rxlifecycle3.components.support.RxFragment
import org.kodein.di.Kodein
import org.kodein.di.Kodein.Companion.lazy
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

abstract class BaseFragment : RxFragment(), KodeinAware {
    private val parentKodein by kodein()

    open val dependencies: (Kodein.MainBuilder.() -> Unit)? = null

    override val kodein by lazy {
        extend(parentKodein)

        dependencies?.invoke(this)
    }
}
