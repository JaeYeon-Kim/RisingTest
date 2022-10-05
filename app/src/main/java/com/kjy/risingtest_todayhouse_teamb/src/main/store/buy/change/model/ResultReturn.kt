package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.model

import com.google.gson.annotations.SerializedName

data class ResultReturn (
    @SerializedName("name") val storeName: String,
    @SerializedName("header") val storeSeller: String,
    @SerializedName("address") val storeAddress: String,
    @SerializedName("customerServiceNumber") val storePhoneNumber: String,
    @SerializedName("email") val email: String,
    @SerializedName("companyRegistrationNumber") val companyNumber: String
        )