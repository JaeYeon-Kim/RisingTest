package com.kjy.risingtest_todayhouse_teamb.src.login.loginemail

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityEmailLoginBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.LoginActivity

class EmailLoginActivity : BaseActivity<ActivityEmailLoginBinding>(ActivityEmailLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이메일로 로그인 액티비티에서 버튼 클릭시 뒤로 감
        backEmailLogin()

        // 이메일 editText 담을 변수
        var messageEmail = ""
        // 패스워드 editText 담을 변수
        var messagePassword = ""


        // 버튼 기본 비활성화 처리
        binding.emailLoginBtnLogin.isEnabled = false

        binding.emailLoginEtEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            // editText에 변동이 있을 경우의 메소드
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // 메세지 변수에 에딧텍스트로 입력한 값 달기
                messageEmail = binding.emailLoginEtEmail.text.toString()

                binding.emailLoginBtnLogin.isEnabled = messageEmail.isNotEmpty()

            }

            override fun afterTextChanged(p0: Editable?) {}

        })

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