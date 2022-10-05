package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model

import com.google.gson.annotations.SerializedName
import com.kjy.risingtest_todayhouse_teamb.config.BaseResponse

data class InquiryResponse(
    @SerializedName("result") val result: ArrayList<ResultInquiry>
    ): BaseResponse()