package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.ReviewResponse
import retrofit2.Call
import retrofit2.http.GET

interface ReviewRetrofitInterface {
    @GET("/app/stores/review/:item-id")
    fun getReview() : Call<ReviewResponse>
}