package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail

import android.content.Intent
import android.os.Bundle
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityEmailLoginBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.LoginActivity

class EmailLoginActivity : BaseActivity<ActivityEmailLoginBinding>(ActivityEmailLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이메일로 로그인 액티비티에서 버튼 클릭시 뒤로 감
        backEmailLogin()

    }

    override fun onBackPressed() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun backEmailLogin() {
        binding.emailLoginBtnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}