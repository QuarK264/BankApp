package com.bank.app.core.base

interface Interactor<in Request, out Response> {
    fun execute(request: Request): Response
}