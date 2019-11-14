package com.application.zomato.listapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * created by championswimmer on 2019-11-14
 * Copyright (c) 2019 Zomato Media Pvt. Ltd.
 */
interface ReqResAPI {

    @GET("users")
    fun getUsers(
        @Query("per_page") perPage: Int = 5
    ): Call<UsersResponse>
}