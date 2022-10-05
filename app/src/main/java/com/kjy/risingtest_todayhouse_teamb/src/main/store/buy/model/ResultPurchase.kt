package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import com.google.gson.annotations.SerializedName

data class ResultPurchase (
    @SerializedName("optional") val optional: String,
    @SerializedName("additional") val additional: String,
    @SerializedName("addPrice") val addPrice: Int
        )