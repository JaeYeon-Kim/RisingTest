package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class ResultReview (
    @SerializedName("nickname") val nickname: String,
    @SerializedName("starRating") val starRating: Int,
    @SerializedName("createdDate") val reviewDate: Timestamp,
    @SerializedName("optional") val buyOption: String,
    @SerializedName("writing") val writing: String
        )
