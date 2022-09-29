package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.BuyInfoResponse

interface BuyInfoInterface {

    fun onGetInfoSuccess(response: BuyInfoResponse)

    fun onGetInfoFailure(message: String)
}