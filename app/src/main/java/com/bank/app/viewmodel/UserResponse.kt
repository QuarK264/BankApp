package com.bank.app.viewmodel

import com.bank.app.ui.details.model.User

class UserResponse(val status: Status, val data: User?, val error: Throwable?) {
    companion object {
        fun loading() = UserResponse(Status.LOADING, null, null)
        fun success(data: User) = UserResponse(Status.SUCCESS, data, null)
        fun error(error: Throwable) = UserResponse(Status.ERROR, null, error)
    }
}