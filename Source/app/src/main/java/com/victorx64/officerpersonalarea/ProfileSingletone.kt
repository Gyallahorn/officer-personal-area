//package com.victorx64.officerpersonalarea
//
//import android.content.ContentValues.TAG
//import android.util.Log
//import com.victorx64.officerpersonalarea.Retrofit.MinzdravUser
//import com.victorx64.officerpersonalarea.Retrofit.RetrofitSingletone
//import retrofit2.Call
//import retrofit2.Response
//import javax.security.auth.callback.Callback
//
//class ProfileSingletone {
//    private var user: MinzdravUser? = null
//
//    fun SetUser(user: MinzdravUser) {
//        this.user = user
//    }
//
//    fun GetUser(callback: (Any) -> Unit) {
//        if (user == null) {
//            RetrofitSingletone.getInstance().GetUser(object : Callback<MinzdravUser> {
//                override fun onResponse(call: Call<MinzdravUser>, response: Response<MinzdravUser>) {
//                    if (response.isSuccessful) {
//                        user = response.body()
//                        callback?.OnBackData(user)
//                    } else {
//                        Log.d(TAG, "Responce error" + response.message())
//                    }
//                }
//
//                override fun onFailure(call: Call<MinzdravUser>, t: Throwable) {
//                }
//            })
//        } else callback?.OnBackData(user)
//    }
//companion object{
//private var instance : ProfileSingletone? = null
//    fun getInstance(): ProfileSingletone? {
//        var localInstance = instance
//        if (localInstance == null) {
//            synchronized(ProfileSingletone::class.java) {
//                localInstance = instance
//                if (localInstance == null) {
//                    localInstance = ProfileSingletone()
//                    instance = localInstance
//                }
//            }
//        }
//        return localInstance
//    }
//}
//}
//}