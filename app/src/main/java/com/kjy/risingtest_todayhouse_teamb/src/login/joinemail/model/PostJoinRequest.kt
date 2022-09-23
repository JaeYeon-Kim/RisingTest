package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model

import com.google.gson.annotations.SerializedName

class PostJoinRequest(
    @SerializedName("EMAIL") val email: String,
    @SerializedName("PASSWORD") val password: String,
    @SerializedName("NICKNAME") val nickname: String
)