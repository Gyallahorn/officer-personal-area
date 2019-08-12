package com.victorx64.officerpersonalarea.Retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MinzdravApi {
    @GET("api/user")
    fun getUser(@Header("idtoken") idToken: String?): Call<MinzdravUser>

    @POST("/api/user")
    fun postUser(@Header("idToken") idToken: String?, @Body body: MinzdravUser): Call<MinzdravUser>

companion object Factory{
    fun sendUser(): MinzdravApi{
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://officer-personal-area.herokuapp.com")
                .build()
        return retrofit.create(MinzdravApi::class.java)
    }

}


}