package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail

import android.util.Log
import com.kjy.risingtest_todayhouse_teamb.config.ApplicationClass
import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model.LoginResponse
import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// 실제 요청을 해주는 서비스 클래스
class LoginService(val emailLoginInterface: EmailLoginInterface) {

    fun tryPostLogin(postLoginRequest: PostLoginRequest) {
       val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
       loginRetrofitInterface.postLogin(postLoginRequest).enqueue(object: Callback<LoginResponse>{
           override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
               if(response.body() != null) {
                   emailLoginInterface.onPostLoginSuccess(response.body() as LoginResponse)
               }else {
                   Log.e("성공적인 API 연동이지만 null값인 경우", "${response.body()}")
               }
           }

           override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

               emailLoginInterface.onPostLoginFailure(t.message ?: "통신 오류")
           }

       })
    }
}