package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityBuyBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.BuyPagerAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.BuyPagerData

class BuyActivity : BaseActivity<ActivityBuyBinding>(ActivityBuyBinding::inflate) {

    // 상품 구매 액티비티 데이터를 담는 리스트
    private var buyPagerList = mutableListOf<BuyPagerData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buyBtnBack.setOnClickListener {
            onBackPressed()
            finish()
        }

        // 상품 구매 액티비티 뷰페이저
        buyPager()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun buyPager() {
        val adapter = BuyPagerAdapter()
        binding.buyVp.adapter = adapter
        buyPagerList.apply {
            add(BuyPagerData(R.drawable.store_viewpager_image_1))
            add(BuyPagerData(R.drawable.store_viewpager_image_2))
            add(BuyPagerData(R.drawable.store_viewpager_image_3))
            add(BuyPagerData(R.drawable.store_viewpager_image_4))
        }
        binding.buyVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        adapter.buyPagerList = buyPagerList
    }
}