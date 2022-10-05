package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.model

import com.google.gson.annotations.SerializedName
import com.kjy.risingtest_todayhouse_teamb.config.BaseResponse

// 판매자 정보를 받는 API 응답 클래스
class ReturnResponse (
    @SerializedName("result") val result: ResultReturn
        ): BaseResponse()