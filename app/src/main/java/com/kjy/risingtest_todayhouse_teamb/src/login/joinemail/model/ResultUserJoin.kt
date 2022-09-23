package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model

import com.google.gson.annotations.SerializedName

data class ResultUserJoin (
    @SerializedName("jwt") val jwt: String,
    @SerializedName("userIdx") val userIdx: Int)
