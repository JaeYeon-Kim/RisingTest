package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail

import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model.PostJoinRequest
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model.UserJoinResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JoinRetrofitInterface {
    @POST("/app/users/sign-up")
    fun postUserJoin(@Body params: PostJoinRequest) : Call<UserJoinResponse>
}