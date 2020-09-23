package com.bank.app.api.models

import kotlinx.serialization.Serializable

@Serializable
class UserWrapper(
    val users: List<User>
)