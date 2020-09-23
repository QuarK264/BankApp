package com.bank.app.viewmodel

class ValuteResponse(val status: Status, val error: Throwable?) {
    companion object {
        fun error(error: Throwable) = UserResponse(Status.ERROR, null, error)
    }
}