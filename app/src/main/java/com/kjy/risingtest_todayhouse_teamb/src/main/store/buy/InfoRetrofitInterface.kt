package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.BuyInfoResponse
import retrofit2.Call
import retrofit2.http.GET

interface InfoRetrofitInterface {
    @GET("/app/stores/item/info-tap/:item-id")
    fun getInfo(): Call<BuyInfoResponse>
}