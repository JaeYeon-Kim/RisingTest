package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change

import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.model.ReturnResponse

interface ReturnActivityInterface {
    fun onGetReturnSuccess(response: ReturnResponse)

    fun onGetFailure(message: String)
}