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
import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model.LoginResponse
import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.model.PostLoginRequest
import com.kjy.risingtest_todayhouse_teamb.src.main.MainActivity
import java.util.regex.Pattern

class EmailLoginActivity : BaseActivity<ActivityEmailLoginBinding>(ActivityEmailLoginBinding::inflate), EmailLoginInterface {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이메일로 로그인 액티비티에서 버튼 클릭시 뒤로 감
        backEmailLogin()


        // 이메일 editText를 감지하는 리스너
        binding.emailLoginEtEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val loginEmail = binding.emailLoginEtEmail.text.toString()
                val loginPassword = binding.emailLoginEtPassword.text.toString()

                binding.emailLoginBtnComplete.isEnabled = loginEmail.isNotEmpty() && loginPassword.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        // 비밀번호 editText에 대한 editText 감지
        binding.emailLoginEtPassword.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val loginPassword = binding.emailLoginEtPassword.text.toString()
                val loginEmail = binding.emailLoginEtEmail.text.toString()
                binding.emailLoginBtnComplete.isEnabled = loginPassword.isNotEmpty() && loginEmail.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.emailLoginBtnComplete.setOnClickListener {
            val email = binding.emailLoginEtEmail.text.toString()
            val password = binding.emailLoginEtPassword.text.toString()
            val postLoginRequest = PostLoginRequest(email = email, password = password)
            LoginService(this).tryPostLogin(postLoginRequest)
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

    override fun onPostLoginSuccess(response: LoginResponse?) {
//        response.message?.let { showCustomToast(it)}
        if(response?.isSuccess == true) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            showCustomToast("아이디 또는 비밀번호가 잘못되었습니다.")
        }
    }

    override fun onPostLoginFailure(message: String) {
        showCustomToast("오류 : $message")
    }
}