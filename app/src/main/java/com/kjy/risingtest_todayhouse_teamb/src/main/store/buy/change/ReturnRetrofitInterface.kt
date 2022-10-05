package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.model.ReturnResponse
import retrofit2.Call
import retrofit2.http.GET

interface ReturnRetrofitInterface {
    @GET("/app/stores/seller-info/1")
    fun getReturn() : Call<ReturnResponse>
}