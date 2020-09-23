package com.bank.app.api

import okhttp3.HttpUrl

object BankContracts {
    enum class Server {
        DEV;

        val usersApi
            get() = when (this) {
                DEV -> HttpUrl.Builder()
                    .scheme(SCHEME_HTTPS)
                    .host(USERS_HOST_URL)
                    .addPathSegments("$API_PREFIX$API_PLATFORM$VERSION_PREFIX")
                    .build()
            }
        val valuteApi
            get() = when (this) {
                DEV -> HttpUrl.Builder()
                    .scheme(SCHEME_HTTPS)
                    .host(VALUTE_HOST_URL)
                    .build()
            }

        companion object {
            const val SCHEME_HTTPS = "https"

            const val USERS_HOST_URL = "hr.peterpartner.net"

            const val API_PREFIX = "test/"

            const val API_PLATFORM = "android/"

            const val VERSION_PREFIX = "v1/"

            const val VALUTE_HOST_URL = "cbr-xml-daily.ru"
        }
    }
}