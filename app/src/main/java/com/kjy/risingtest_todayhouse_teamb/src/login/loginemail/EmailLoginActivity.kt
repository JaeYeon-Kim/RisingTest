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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이메일로 로그인 액티비티에서 버튼 클릭시 뒤로 감
        backEmailLogin()

        // 버튼 비활성화
        binding.emailLoginBtnComplete.isEnabled = false

        // 이메일 editText를 감지하는 리스너
        binding.emailLoginEtEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val loginEmail = binding.emailLoginEtEmail.text.toString()
                val loginPassword = binding.emailLoginEtPassword.text.toString()
                binding.emailLoginBtnComplete.isEnabled = loginEmail.trim().isNotEmpty() && loginPassword.trim().isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.emailLoginBtnComplete.setOnClickListener {
            showCustomToast("로그인이 되었습니다!!")
        }
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