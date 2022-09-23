package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model

import com.google.gson.annotations.SerializedName

// 서버에서 요청을 한 후에 응답 받는 데이터 클래스(isSuccess, code, message 동일 그후 result까지 받아옴)
data class UserJoinResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ResultUserJoin)