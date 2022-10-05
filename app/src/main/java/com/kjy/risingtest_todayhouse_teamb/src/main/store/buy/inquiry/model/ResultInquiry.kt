package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model

import com.google.gson.annotations.SerializedName

data class ResultInquiry (
    @SerializedName("nickname") val nickname: String,
    @SerializedName("createdDate") val questionDate: String,
    @SerializedName("question") val questionText: String,
    @SerializedName("answer") val answerText: String,
    @SerializedName("progress") var answerProgress: Int,        // 답변 여부(0: 미답변 / 1: 답변완료)
    @SerializedName("secret") var secret: Int,                  // 비밀글 여부(0: 비밀글x / 1: 비밀글)
    @SerializedName("type") var type: String                // 문의 유형(상품, 배송, 반품 등등)
    )