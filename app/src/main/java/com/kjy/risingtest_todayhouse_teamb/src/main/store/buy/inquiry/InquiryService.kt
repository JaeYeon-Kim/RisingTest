package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry

import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model.InquiryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InquiryService(val inquiryActivityInterface: InquiryActivityInterface) {
    fun tryGetInquiry() {
        val inquiryRetrofitInterface = ApplicationClass.sRetrofit.create(InquiryRetrofitInterface::class.java)
        inquiryRetrofitInterface.getInquiry().enqueue(object: Callback<InquiryResponse> {
            override fun onResponse(call: Call<InquiryResponse>, response: Response<InquiryResponse>) {
                if(response.isSuccessful) {
                  inquiryActivityInterface.onGetInquirySuccess(response.body() as InquiryResponse)
                }
            }

            override fun onFailure(call: Call<InquiryResponse>, t: Throwable) {
                inquiryActivityInterface.onGetInquiryFailure(t.message?: "통신 오류")
            }

        })
    }
}