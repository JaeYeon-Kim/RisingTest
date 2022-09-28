package com.kjy.risingtest_todayhouse_teamb.src.main.store.model

import com.google.gson.annotations.SerializedName

data class ResultHomeMain (
    @SerializedName("id") val id: Int,                  // 상품 id
    @SerializedName("shopName") val storeTitle: String, // 스토어명
    @SerializedName("itemName") val goodsTitle: String, // 상품명
    @SerializedName("price") val originPrice: Int,      // 상품원가
    @SerializedName("discountRate") val percentRate: Int, // 상품할인율
    @SerializedName("reviewCnt") val reviewCount: Int,  // 상품의 총 리뷰수
    @SerializedName("starAvg") val reviewScore: Float,  // 별점 스코어(평균치)
    @SerializedName("deliveryFee") val deliveryPrice: Int,  // 배송비
    @SerializedName("specialPrice") val specialPrice: Int, // 특가 구별 용 1이면 특가 0이면 특가 아님
    @SerializedName("mediumId") val mediumId: Int           // 중분류 ID
        )