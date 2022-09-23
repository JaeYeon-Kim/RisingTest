package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail

import android.content.Intent
import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model.PostJoinRequest
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model.UserJoinResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// 실제로 요청을 하는 서비스 객체
// 회원가입
class JoinService(val emailJoinInterface: EmailJoinInterface) {

    // 회원 가입 요청을 하였을때 성공과 실패 여부로 나뉨
    fun tryPostJoin(postJoinRequest: PostJoinRequest) {
        val joinRetrofitInterface = ApplicationClass.sRetrofit.create(JoinRetrofitInterface::class.java)
        joinRetrofitInterface.postUserJoin(postJoinRequest).enqueue(object : Callback<UserJoinResponse> {
            override fun onResponse(call: Call<UserJoinResponse>, response: Response<UserJoinResponse>) {
                if(response.body() != null){
                    emailJoinInterface.onPostJoinSuccess(response.body() as UserJoinResponse)
                }else {
                    Log.e("성공적으로 받아왔는데 값이 비어있을때:","${response.body()}")
                }
            }

            override fun onFailure(call: Call<UserJoinResponse>, t: Throwable) {
                emailJoinInterface.onPostJoinFailure(t.message ?: "통신 오류")
            }

        })
    }
}