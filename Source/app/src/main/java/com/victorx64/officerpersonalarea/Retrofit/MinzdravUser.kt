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

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("gender")
    @Expose
    var gender: Boolean? = null

    @SerializedName("age")
    @Expose
    var age: String? = null

    @SerializedName("snils")
    @Expose
    var snils: String? = null

    @SerializedName("polis")
    @Expose
    var polis: String? = null

    @SerializedName("work_place")
    @Expose
    var work_place: String? = null
}