package com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.expert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityExpertWebBinding

class ExpertWebActivity : BaseActivity<ActivityExpertWebBinding>(ActivityExpertWebBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 웹뷰 연동하기
        binding.webView.apply {
            // 웹뷰 클라이언트 객체 생성
            webViewClient = WebViewClient()
            // 웹뷰에 로드하려는 웹 페이지가 자바스크립트를 사용하는 경우에 자바스크립트를 사용하도록 설정
            settings.javaScriptEnabled = true
        }
        binding.webView.loadUrl("https://pro.ohou.se/?utm_source=ohouse_app&utm_medium=app(andro)&utm_campaign=prosignup&utm_content=adr_emailsignup")

    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}