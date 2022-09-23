package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model

import com.google.gson.annotations.SerializedName

data class ResultLogin(
    @SerializedName("jwt") val jwt : String,
    @SerializedName("userIdx") val userIdx: Int
)