package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail

import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model.LoginResponse

interface EmailLoginInterface {

    // 성공 함수
    fun onPostLoginSuccess(response: LoginResponse?)

    // 실패 함수
    fun onPostLoginFailure(message: String)
}