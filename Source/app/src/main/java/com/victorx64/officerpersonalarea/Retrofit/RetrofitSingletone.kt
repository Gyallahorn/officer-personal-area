package com.victorx64.officerpersonalarea.Retrofit

import com.google.firebase.auth.FirebaseAuth
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitSingletone private constructor() {
    private val mRetrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)

        val rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
        mRetrofit = Retrofit.Builder()
                .baseUrl("https://officer-personal-area.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .client(client.build())
                .build()

    }

//    private fun GetIdToken(idTokenCallBack: IdTokenCallBack) {
//        FirebaseAuth.getInstance().currentUser?.getIdToken(false)?.addOnSuccessListener { getTokenResult -> idTokenCallBack.onIdTokenBack(getTokenResult.token) }
//    }
//
//    fun GetUser(callback: Callback<MinzdravUser>) {
//        val idTokenCallBack = object : IdTokenCallBack {
//            override fun onIdTokenBack(idToken: String?) {
//                mRetrofit.create(MinzdravApi::class.java).getUser(idToken).enqueue(callback)
//            }
//        }
//        GetIdToken(idTokenCallBack)
//    }
//
//    fun PostUser(callback: Callback<MinzdravUser>, user: MinzdravUser){
//        val idTokenCallBack = object : IdTokenCallBack {
//            override fun onIdTokenBack(idToken: String?) {
//                if (idToken!=null){
//                mRetrofit.create(MinzdravApi::class.java).postUser(idToken, user).enqueue(callback)
//                 }
//            }
//        }
//        GetIdToken(idTokenCallBack)
//    }
//
//    companion object {
//
//        @Volatile
//        private var instance: RetrofitSingletone? = null
//
//        fun getInstance(): RetrofitSingletone {
//            var localInsance = instance
//            if (localInsance == null) {
//                synchronized(RetrofitSingletone::class.java) {
//                    localInsance = instance
//                    if (localInsance == null) {
//                        localInsance = RetrofitSingletone()
//                        instance = localInsance
//
//                    }
//                }
//
//            }
//            return localInsance as RetrofitSingletone
//        }
//
//        private val TAG = RetrofitSingletone.javaClass.simpleName
//    }
}