package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import com.google.gson.annotations.SerializedName
import com.kjy.risingtest_todayhouse_teamb.config.BaseResponse

data class PurchaseResponse(
    @SerializedName("result") val result: ArrayList<ResultPurchase>
):BaseResponse()