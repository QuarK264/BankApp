package com.bank.app.core.extension

import com.bank.app.core.base.Interactor

fun <T> Interactor<Unit, T>.execute() = execute(Unit)