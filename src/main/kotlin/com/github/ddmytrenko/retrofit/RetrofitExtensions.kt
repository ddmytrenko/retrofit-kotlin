package com.github.ddmytrenko.retrofit

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder

private const val URL_POSTFIX = "/"

fun Builder.safeBaseUrl(baseUrl: String): Builder {
    val postfix = if (baseUrl.endsWith(URL_POSTFIX)) "" else URL_POSTFIX
    return baseUrl(baseUrl + postfix)
}

inline fun buildRetrofit(
    baseUrl: String,
    builder: Builder.() -> Unit
): Retrofit =
    Builder().apply {
        safeBaseUrl(baseUrl)
        builder()
    }.build()

inline fun <reified T : Any> Retrofit.createService(): T =
    create(T::class.java)
