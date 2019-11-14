package com.application.zomato.listapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * created by championswimmer on 2019-11-14
 * Copyright (c) 2019 Zomato Media Pvt. Ltd.
 */
interface ZomatoAPI {

    @GET("/cities")
    fun getCities(
        @Query("q") q: String,
        @Header("user-key") userKey: String
    ): Call<CitiesResponse>
}