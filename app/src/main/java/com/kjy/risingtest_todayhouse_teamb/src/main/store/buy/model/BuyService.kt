package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.BuyActivityInterface
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.BuyRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BuyService(val buyActivityInterface: BuyActivityInterface) {

    // 스토어 상세 - 리뷰
    fun tryGetReview() {
        val buyRetrofitInterface = ApplicationClass.sRetrofit.create(BuyRetrofitInterface::class.java)
        buyRetrofitInterface.getBuyReview().enqueue(object: Callback<ReviewResponse>{
            override fun onResponse(call: Call<ReviewResponse>, response: Response<ReviewResponse>) {
                if(response.isSuccessful) {
                    buyActivityInterface.onGetReviewSuccess(response.body() as ReviewResponse)
                }else{
                    Log.e("리뷰 API를 성공적으로 받아왔지만 응답이 올바르지 않을 경우", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                buyActivityInterface.onGetReviewFailure(t.message?: "통신 오류")
            }

        })
    }

    // 스토어 상세 - 이미지들 불러오기
    fun tryGetGoodsInfo() {
        val buyRetrofitInterface = ApplicationClass.sRetrofit.create(BuyRetrofitInterface::class.java)
        buyRetrofitInterface.getBuyGoodsInfo().enqueue(object: Callback<InfoResponse>{
            override fun onResponse(call: Call<InfoResponse>, response: Response<InfoResponse>) {
                if(response.isSuccessful) {
                    buyActivityInterface.onGetGoodsInfoSuccess(response.body() as InfoResponse)
                }
            }

            override fun onFailure(call: Call<InfoResponse>, t: Throwable) {
                buyActivityInterface.onGetGoodsInfoFailure(t.message?: "통신 오류")
            }

        })
    }

    // 스토어 상세 - 세부정보 1 가져오기
    fun tryGetDetail() {
        val buyRetrofitInterface = ApplicationClass.sRetrofit.create(BuyRetrofitInterface::class.java)
        buyRetrofitInterface.getBuyDetail().enqueue(object: Callback<DetailResponse>{
            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
                if(response.isSuccessful) {
                    buyActivityInterface.onGetDetailSuccess(response.body() as DetailResponse)
                }
            }

            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                buyActivityInterface.onGetDetailFailure(t.message?: "통신 오류")
            }

        })
    }

    // 스토어 상세 - 세부정보 2 가져오기
    fun tryGetAdd(){
        val buyRetrofitInterface = ApplicationClass.sRetrofit.create(BuyRetrofitInterface::class.java)
        buyRetrofitInterface.getBuyAdd().enqueue(object: Callback<AddResponse>{
            override fun onResponse(call: Call<AddResponse>, response: Response<AddResponse>) {
                if(response.isSuccessful) {
                    buyActivityInterface.onGetAddSuccess(response.body() as AddResponse)
                }
            }

            override fun onFailure(call: Call<AddResponse>, t: Throwable) {
                buyActivityInterface.onGetAddFailure(t.message?: "통신 오류")
            }

        })
    }
}