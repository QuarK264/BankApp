package com.bank.app.viewmodel

import com.bank.app.core.domain.entities.User

class Response(val status: Status, val data: User?, val error: Throwable?) {
    companion object {
        fun loading() = Response(Status.LOADING, null, null)
        fun success(data: User) = Response(Status.SUCCESS, data, null)
        fun error(error: Throwable) = Response(Status.ERROR, null, error)
    }
}