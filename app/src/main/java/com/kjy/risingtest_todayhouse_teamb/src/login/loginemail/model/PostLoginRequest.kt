package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model

import com.google.gson.annotations.SerializedName

// 요청 값이 담김
data class PostLoginRequest (
    @SerializedName("EMAIL") val email: String,
    @SerializedName("PASSWORD") val password: String)