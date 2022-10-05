package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model.InquiryResponse
import retrofit2.Call
import retrofit2.http.GET

interface InquiryRetrofitInterface {
    @GET("/app/stores/inquiry/2")
    fun getInquiry() : Call<InquiryResponse>
}