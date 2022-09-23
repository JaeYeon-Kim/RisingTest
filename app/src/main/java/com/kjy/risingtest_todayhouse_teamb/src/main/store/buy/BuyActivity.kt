package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityBuyBinding

class BuyActivity : BaseActivity<ActivityBuyBinding>(ActivityBuyBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buyBtnBack.setOnClickListener {
            onBackPressed()
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}