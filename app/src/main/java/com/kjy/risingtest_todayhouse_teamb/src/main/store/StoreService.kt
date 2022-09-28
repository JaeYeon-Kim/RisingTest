package com.kjy.risingtest_todayhouse_teamb.src.main.store

import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.StoreHomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreService(val storeFragmentInterface: StoreFragmentInterface) {

    fun tryGetHomeMain() {
        val storeRetrofitInterface = ApplicationClass.sRetrofit.create(StoreRetrofitInterface::class.java)
        storeRetrofitInterface.getHomeMain().enqueue(object: Callback<StoreHomeResponse> {
            override fun onResponse(call: Call<StoreHomeResponse>, response: Response<StoreHomeResponse>) {
                if(response.isSuccessful) {
                    Log.d("값이 잘들어왔나요?", "${response.body()}")
                    storeFragmentInterface.onGetHomeMainSuccess(response.body() as StoreHomeResponse)
                }else {
                    Log.e("통신이 실패:", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<StoreHomeResponse>, t: Throwable) {
                storeFragmentInterface.onGetHomeMainFailure(t.message ?: "통신 오류")
            }

        })
    }
}