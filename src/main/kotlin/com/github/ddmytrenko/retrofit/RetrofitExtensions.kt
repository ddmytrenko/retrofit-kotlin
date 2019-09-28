package com.github.ddmytrenko.retrofit

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder

inline fun buildRetrofit(
    baseUrl: String,
    builder: Builder.() -> Unit
): Retrofit =
    Builder().apply {
        baseUrl(baseUrl)
        builder()
    }.build()

inline fun <reified T : Any> Retrofit.createService(): T =
    create(T::class.java)
