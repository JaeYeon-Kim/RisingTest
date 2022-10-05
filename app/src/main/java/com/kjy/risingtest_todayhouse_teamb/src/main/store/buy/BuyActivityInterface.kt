package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.*

interface BuyActivityInterface {

    fun onGetReviewSuccess(response: ReviewResponse)

    fun onGetReviewFailure(message: String)

    fun onGetGoodsInfoSuccess(response: InfoResponse)

    fun onGetGoodsInfoFailure(message: String)

    fun onGetDetailSuccess(response: DetailResponse)

    fun onGetDetailFailure(message: String)

    fun onGetAddSuccess(response: AddResponse)

    fun onGetAddFailure(message: String)
}