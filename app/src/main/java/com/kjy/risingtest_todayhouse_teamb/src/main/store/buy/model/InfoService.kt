package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.BuyInfoInterface
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.InfoRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoService(val buyInfoInterface: BuyInfoInterface) {
    fun tryGetInfo() {
        val infoRetrofitInterface = ApplicationClass.sRetrofit.create(InfoRetrofitInterface::class.java)
        infoRetrofitInterface.getInfo().enqueue(object: Callback<BuyInfoResponse> {
            override fun onResponse(
                call: Call<BuyInfoResponse>,
                response: Response<BuyInfoResponse>
            ) {
                if(response.isSuccessful) {
                    buyInfoInterface.onGetInfoSuccess(response.body() as BuyInfoResponse)
                }else {
                    Log.e("통신 실패:", "onResponse 실패 ")
                }
            }

            override fun onFailure(call: Call<BuyInfoResponse>, t: Throwable) {
                buyInfoInterface.onGetInfoFailure(t.message?: "통신 오류")
            }

        })
    }
}