package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.*
import retrofit2.Call
import retrofit2.http.GET

interface BuyRetrofitInterface {
    // 스토어 상세(구매하기 액티비티) - 리뷰
    @GET("/app/stores/review/1")
    fun getBuyReview(): Call<ReviewResponse>

    // 스토어 상세(구매하기 액티비티) - 상품 상세 정보 이미지들
    @GET("/app/stores/item/info-tap/1")
    fun getBuyGoodsInfo(): Call<InfoResponse>

    // 스토어 상세(구매하기 액티비티) - 상품 상세 정보들(스토어명, 상품명, 원가 등등)
    @GET("/app/stores/home")
    fun getBuyDetail(): Call<DetailResponse>

    // 스토어 상세(구매하기 액티비티) - 바텀시트 다이얼로그 상품 구매하기
    @GET("/app/stores/item/purchase/1")
    fun getBuyPurchase(): Call<PurchaseResponse>

    // 스토어 상세(구매하기 액티비티) - 상품 상세 정보 추가(상품 배송카테고리명, 스크랩 수)
    @GET("/app/stores/item/1")
    fun getBuyAdd(): Call<AddResponse>
}