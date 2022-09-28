package com.kjy.risingtest_todayhouse_teamb.src.main.store

import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.StoreHomeResponse

interface StoreFragmentInterface {

    // 성공적으로 받아와서 reponse에 reponse.body() 값이 담긴채로 들어옴
    fun onGetHomeMainSuccess(response: StoreHomeResponse)

    fun onGetHomeMainFailure(message: String)
}