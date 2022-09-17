package com.kjy.risingtest_todayhouse_teamb.src.login

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 로그인 액티비티의 특정 글씨 굵게하는 커스텀 적용
        loginTextCustom()

    }

    // 로그인 액티비티의 "최대 10만원" 글씨의 굵기를 적용함
    private fun loginTextCustom() {
        // 텍스트 데이터 변수 얻음
        val loginText = binding.loginTvMain1

        // 변환해주는 Builder 생성
        val builder = SpannableStringBuilder("지금 가입하면 최대 10만원")

        val boldSpan = StyleSpan(Typeface.BOLD)
        builder.setSpan(boldSpan, 8, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        loginText.text = builder
    }
}