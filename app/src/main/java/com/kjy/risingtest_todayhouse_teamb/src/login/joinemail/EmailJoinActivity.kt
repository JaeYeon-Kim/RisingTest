package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityEmailJoinBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.LoginActivity
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.expert.ExpertWebActivity
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model.PostJoinRequest
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.model.UserJoinResponse
import com.kjy.risingtest_todayhouse_teamb.src.main.MainActivity
import java.util.regex.Pattern

class EmailJoinActivity : BaseActivity<ActivityEmailJoinBinding>(ActivityEmailJoinBinding::inflate), EmailJoinInterface {

    val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 버튼 비활성화
        binding.emailJoinBtnComplete.isClickable = false

        // 백 버튼 클릭시 뒤로가기
        emailJoinBack()

        // 인테리어 전문가이시다면 버튼 클릭시 이벤트
        expertWebGo()

        binding.emailJoinCheckBoxWhole.setOnClickListener{onCheckBoxChanged(binding.emailJoinCheckBoxWhole)}

        // EditText에 TextWatcher 연결
        binding.emailJoinEtEmail.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 실시간 변경 이벤트
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkEmail()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        // 회원가입 버튼 이벤트
        binding.emailJoinBtnComplete.setOnClickListener {
            if(!checkEmail()) {
                showCustomToast("이메일 형식에 맞게 입력하세요")
            }else {
                showCustomToast("가입 완료") }
        }

        // 회원가입 버튼 클릭시 API 정보를 받아 회원가입 처리를 구현
        binding.emailJoinBtnComplete.setOnClickListener {
            val email = binding.emailJoinEtEmail.text.toString()
            var password = binding.emailJoinEtPassword.text.toString()
            val passwordCheck = binding.emailJoinEtPasswordCheck.text.toString()
            password == passwordCheck
            val nickname = binding.emailJoinEtNickname.text.toString()
            val postRequest = PostJoinRequest(email = email, password = password, nickname = nickname)
            JoinService(this).tryPostJoin(postRequest)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    // 스마트폰 뒤로가기 구현
    override fun onBackPressed() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    // 이메일로 가입 화면에서 백 버튼 클릭시 뒤로가기
    private fun emailJoinBack() {
        binding.emailJoinBtnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // 인테리어 전문가이시다면 버튼 클릭시 해당 웹뷰 액티비티로 이동
    private fun expertWebGo() {
        binding.emailJoinBtnExpert.setOnClickListener {
            val intent = Intent(this, ExpertWebActivity::class.java)
            startActivity(intent)
        }
    }

    // 체크박스 전부 체크 하는 이벤트 생성
    // compound button => 체크박스, 스위치, 토글 버튼 같은 것을 포함.
    private fun onCheckBoxChanged(compoundButton: CompoundButton) {
        when (compoundButton.id) {
            // 전체 체크박스 버튼을 클릭시 이벤트
            R.id.emailJoin_checkBox_whole -> {
                // 클릭이 됐을 경우 나머지 체크 처리를 true
                if (binding.emailJoinCheckBoxWhole.isChecked) {
                    binding.emailJoinCheckBox1.isChecked = true
                    binding.emailJoinCheckBox2.isChecked = true
                    binding.emailJoinCheckBox3.isChecked = true
                    binding.emailJoinCheckBox4.isChecked = true
                    binding.emailJoinCheckBox5.isChecked = true
                    // 아닐 경우 나머지 체크 처리를 false
                } else {
                    binding.emailJoinCheckBox1.isChecked = false
                    binding.emailJoinCheckBox2.isChecked = false
                    binding.emailJoinCheckBox3.isChecked = false
                    binding.emailJoinCheckBox4.isChecked = false
                    binding.emailJoinCheckBox5.isChecked = false
                }
            }
            R.id.emailJoin_checkBox_1 -> {
                if(binding.emailJoinCheckBox1.isChecked) {
                    if (binding.emailJoinCheckBox2.isChecked) {
                        if(binding.emailJoinCheckBox3.isChecked) {
                            binding.emailJoinBtnComplete.isClickable = true
                        }
                    }
                }
            }
        }

    }

    // 이메일 형식 검사
    private fun checkEmail(): Boolean {
        var email = binding.emailJoinEtEmail.text.toString().trim()     // 공백제거
        val checkPattern = Pattern.matches(emailValidation, email)      // 서로 패턴이 맞는지 확인
        if (checkPattern) {
            // 이메일 형태가 정상일 경우
            binding.emailJoinEtEmail.setTextColor(ContextCompat.getColor(this, R.color.black))
            return true
        }else {
            // 이메일 형태가 올바르지 않을 경우
            binding.emailJoinEtEmail.setTextColor(ContextCompat.getColor(this, R.color.red))
            return false
        }
    }

    // 가입 성공의 경우
    override fun onPostJoinSuccess(response: UserJoinResponse?) {
        response?.message.let {
            if (it != null) {
                showCustomToast(it)
            }
        }
    }


    // 가입 실패의 경우
    override fun onPostJoinFailure(message: String) {
        showCustomToast("오류 : $message")
    }

}