package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail

import android.content.Intent
import android.graphics.Color.red
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityEmailLoginBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.LoginActivity
import java.util.regex.Pattern

class EmailLoginActivity : BaseActivity<ActivityEmailLoginBinding>(ActivityEmailLoginBinding::inflate) {

    // 이메일 정규식
    private val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이메일로 로그인 액티비티에서 버튼 클릭시 뒤로 감
        backEmailLogin()

    }

    // 스마트폰 뒤로가기 활성화
    override fun onBackPressed() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    // 액티비티 뒤로가기
    private fun backEmailLogin() {
        binding.emailLoginBtnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }



}