package com.kjy.risingtest_todayhouse_teamb.src.main.store

import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.StoreHomeResponse
import retrofit2.Call
import retrofit2.http.GET

interface StoreRetrofitInterface {
    @GET("/app/stores/home")
    fun getHomeMain() : Call<StoreHomeResponse>
}