package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.CompoundButton
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityEmailJoinBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.LoginActivity
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.expert.ExpertWebActivity
import java.util.regex.Pattern

class EmailJoinActivity : BaseActivity<ActivityEmailJoinBinding>(ActivityEmailJoinBinding::inflate) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        // 회원가입 완료 버튼 클릭시 이벤트
        binding.emailJoinBtnComplete.setOnClickListener {
            if (!checkEmail()) {
                showCustomToast("이메일 형식에 맞게 입력하세요")
            } else {
                showCustomToast("가입 완료!")
            }
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
        when(compoundButton.id) {
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
        }
    }

    // 이메일 정규식 검사
    fun checkEmail(): Boolean {
        // 이메일 정규식
        val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        var email = binding.emailJoinEtEmail.text.toString().trim()         // 공백 제거
        val checkPattern = Pattern.matches(emailValidation, email)
        if (checkPattern) {
            binding.emailJoinEtEmail.setTextColor(R.color.black.toInt())
            return true
        }else {
            binding.emailJoinEtEmail.setTextColor(R.color.red.toInt())
            return false
        }
    }
}