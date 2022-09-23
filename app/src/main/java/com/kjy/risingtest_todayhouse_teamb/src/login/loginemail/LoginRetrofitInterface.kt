package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail

import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model.LoginResponse
import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// 바디에 값을 담아 요청을 받는 인터페이스
interface LoginRetrofitInterface {
    @POST("/app/users/login")
    fun postLogin(@Body params: PostLoginRequest): Call<LoginResponse>
}