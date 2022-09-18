package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityEmailJoinBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.LoginActivity
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.expert.ExpertWebActivity

class EmailJoinActivity : BaseActivity<ActivityEmailJoinBinding>(ActivityEmailJoinBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 백 버튼 클릭시 뒤로가기
        emailJoinBack()

        // 인테리어 전문가이시다면 버튼 클릭시 이벤트
        expertWebGo()

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
}