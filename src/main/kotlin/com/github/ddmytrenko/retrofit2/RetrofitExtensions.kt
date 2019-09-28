package com.github.ddmytrenko.retrofit2

import retrofit2.Retrofit

inline fun <reified T : Any> Retrofit.createService(): T =
    create(T::class.java)
