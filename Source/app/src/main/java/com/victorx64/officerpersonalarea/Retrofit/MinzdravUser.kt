package com.victorx64.officerpersonalarea.Retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MinzdravUser {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("token")
    @Expose
    var token: String? = null
}