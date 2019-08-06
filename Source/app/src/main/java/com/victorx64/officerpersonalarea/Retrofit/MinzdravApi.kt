package com.victorx64.officerpersonalarea.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MinzdravApi {
@GET("api/user")
fun getUser(@Header("idtoken") idToken: String?): Call<MinzdravUser>

}