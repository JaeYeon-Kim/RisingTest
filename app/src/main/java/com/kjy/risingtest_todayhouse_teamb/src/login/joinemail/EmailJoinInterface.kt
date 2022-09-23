package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail

import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model.UserJoinResponse

// 응답값을 정의 하기 위한 인터페이스
interface EmailJoinInterface {

    fun onPostJoinSuccess(response: UserJoinResponse?)

    fun onPostJoinFailure(message: String)
}