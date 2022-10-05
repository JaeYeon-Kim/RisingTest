package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import com.google.gson.annotations.SerializedName
import com.kjy.risingtest_todayhouse_teamb.config.BaseResponse


// 구매 액티비티에서 가격 스토어명들 디테일 1(쿠폰 등은 제외)
data class DetailResponse (
    @SerializedName("result") val result: ArrayList<ResultDetail>
        ): BaseResponse()