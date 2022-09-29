package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.ReviewResponse

interface BuyReviewInterface {

    fun onGetReviewSuccess(response: ReviewResponse)

    fun onGetReviewFailure(message: String)
}