package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.BuyReviewInterface
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.ReviewRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuyReviewService(val buyReviewInterface: BuyReviewInterface) {

    fun tryGetReview() {
        val reviewRetrofitInterface = ApplicationClass.sRetrofit.create(ReviewRetrofitInterface::class.java)
        reviewRetrofitInterface.getReview().enqueue(object: Callback<ReviewResponse>{
            override fun onResponse(call: Call<ReviewResponse>, response: Response<ReviewResponse>) {
                if(response.body() != null) {
                    buyReviewInterface.onGetReviewSuccess(response.body() as ReviewResponse)
                }else {
                    Log.v("Error code 400", response.errorBody().toString())
                    Log.e("성공적으로 받아왔는데 값이 비어있을때:","${response.body()}")
                }
            }

            override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                buyReviewInterface.onGetReviewFailure(t.message?: "통신 오류")
            }

        })
    }
}
