package com.kjy.risingtest_todayhouse_teamb.src.main.store.model

import com.google.gson.annotations.SerializedName
import com.kjy.risingtest_todayhouse_teamb.config.BaseResponse

data class StoreAdResponse (
    @SerializedName("result") val result: ArrayList<ResultHomeAd>
        ): BaseResponse()