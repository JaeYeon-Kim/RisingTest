package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model

import com.google.gson.annotations.SerializedName
import com.kjy.risingtest_todayhouse_teamb.config.BaseResponse

// 요청에 대한 응답 값이 담김
data class LoginResponse (
    // 베이스 리스폰스 상속받아서 result만 구현
    @SerializedName("result") val result: ResultLogin
    ): BaseResponse()