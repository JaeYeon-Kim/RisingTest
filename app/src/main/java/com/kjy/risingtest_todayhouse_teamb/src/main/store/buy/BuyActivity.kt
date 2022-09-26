package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityBuyBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.*

class BuyActivity : BaseActivity<ActivityBuyBinding>(ActivityBuyBinding::inflate) {

    // 상품 구매 액티비티 - 유저 스타일링샷 데이터를 담는 리스트
    private var buyUserList = mutableListOf<BuyUserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buyBtnBack.setOnClickListener {
            onBackPressed()
            finish()
        }

        // 상품 구매 액티비티 뷰페이저
        buyPager()

        // 유저 스타일링 리사이클러뷰
        buyUserRecycler()

        // 상품 정보 리사이클러뷰
        buyGoodsInfoRecycler()
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun buyPager() {
        val buyPagerList = arrayListOf<BuyPagerData>(
                    BuyPagerData(R.drawable.store_viewpager_image_1),
                    BuyPagerData(R.drawable.store_viewpager_image_2),
                    BuyPagerData(R.drawable.store_viewpager_image_3),
                    BuyPagerData(R.drawable.store_viewpager_image_4))

        val adapter = BuyPagerAdapter(buyPagerList)
        binding.buyVp.adapter = adapter
        binding.buyVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun buyUserRecycler() {
        val adapter = BuyUserAdapter()
        binding.buyRvUserStyling.adapter = adapter
        buyUserList.apply {
            add(BuyUserData(R.drawable.buy_test_image_1))
            add(BuyUserData(R.drawable.buy_test_image_2))
            add(BuyUserData(R.drawable.buy_test_image_3))
            add(BuyUserData(R.drawable.buy_test_image_4))
            add(BuyUserData(R.drawable.buy_test_image_1))
            add(BuyUserData(R.drawable.buy_test_image_2))
            add(BuyUserData(R.drawable.buy_test_image_3))
            add(BuyUserData(R.drawable.buy_test_image_4))
            add(BuyUserData(R.drawable.buy_test_image_4))
            add(BuyUserData(R.drawable.buy_test_image_3))
            add(BuyUserData(R.drawable.buy_test_image_2))
            add(BuyUserData(R.drawable.buy_test_image_1))
        }
        adapter.buyUserList = buyUserList
        val layoutManager = GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
        binding.buyRvUserStyling.layoutManager = layoutManager
    }

    private fun buyGoodsInfoRecycler() {
        val goodsInfoList = arrayListOf<BuyGoodsInfoData>(
            BuyGoodsInfoData(R.drawable.buy_info_image_1),
            BuyGoodsInfoData(R.drawable.buy_info_image_2),
            BuyGoodsInfoData(R.drawable.buy_info_image_3)
        )
        val adapter = BuyGoodsInfoAdapter(goodsInfoList)
        binding.buyRvGoodsInfo.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        binding.buyRvGoodsInfo.layoutManager = layoutManager

    }
}