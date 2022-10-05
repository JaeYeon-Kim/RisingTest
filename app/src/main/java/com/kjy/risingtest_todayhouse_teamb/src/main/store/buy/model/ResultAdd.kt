package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class ResultAdd (
        @SerializedName("shippingCategory") val deliveryMethod: String,
        @SerializedName("scrapCnt") val scrapCount: Int,
        @SerializedName("discountRate") val discountRate: Int,
        @SerializedName("couponName") val couponName: String,
        @SerializedName("basePriceCondition") val basePriceCondition: Int,
        @SerializedName("expDate") val expDate: String
        )