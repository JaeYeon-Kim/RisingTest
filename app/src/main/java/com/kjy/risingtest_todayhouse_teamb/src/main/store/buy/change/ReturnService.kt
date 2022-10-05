package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change

import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.model.ReturnResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ReturnService(val returnActivityInterface: ReturnActivityInterface) {
    fun tryGetReturn() {
        val returnRetrofitInterface = ApplicationClass.sRetrofit.create(ReturnRetrofitInterface::class.java)
        returnRetrofitInterface.getReturn().enqueue(object: Callback<ReturnResponse>{
            override fun onResponse(call: Call<ReturnResponse>, response: Response<ReturnResponse>) {
                if(response.isSuccessful) {
                    returnActivityInterface.onGetReturnSuccess(response.body() as ReturnResponse)
                }
            }

            override fun onFailure(call: Call<ReturnResponse>, t: Throwable) {
                returnActivityInterface.onGetFailure(t.message?: "통신 오류")
            }

        })
    }
}