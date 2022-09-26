package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityBuyBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.*
import kotlin.math.abs

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

        // 상품 리뷰 사진들 리사이클러뷰
        buyReviewPhotoRecycler()


        // 탭 레이아웃 동작 리스너
        binding.buyTabLayoutDetail.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭이 동작 선택되었을 때
                when(tab?.position) {
                    // 상품정보
                    0 -> {
                            binding.buySv.scrollTo(0, binding.buyLayoutDetail.top)
                    }
                    // 리뷰
                    1 -> {
                        binding.buySv.scrollTo(0, binding.buyLayoutReview.top)
                    }
                    // 문의
                    2 -> {
                        binding.buySv.scrollTo(0, binding.buyLayoutQuestion.top)
                    }
                    // 배송/환불
                    3 -> {
                        binding.buySv.scrollTo(0, binding.buyLayoutReturn.top)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 탭이 이미 선택되었을 때
                when(tab?.position) {
                    // 상품정보
                    0 -> {
                        binding.buySv.scrollTo(0, binding.buyLayoutDetail.top)
                    }
                    // 리뷰
                    1 -> {
                        binding.buySv.scrollTo(0, binding.buyLayoutReview.top)
                    }
                    // 문의
                    2 -> {
                        binding.buySv.scrollTo(0, binding.buyLayoutQuestion.top)
                    }
                    // 배송/환불
                    3 -> {
                        binding.buySv.scrollTo(0, binding.buyLayoutReturn.top)
                    }
                }
            }

        })
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

    private fun buyReviewPhotoRecycler() {
        val reviewPhotoList = arrayListOf<BuyReviewPhotoData>(
            BuyReviewPhotoData(R.drawable.buy_test_image_1),
            BuyReviewPhotoData(R.drawable.buy_test_image_2),
            BuyReviewPhotoData(R.drawable.buy_test_image_3),
            BuyReviewPhotoData(R.drawable.buy_test_image_4)
        )
        val adapter = BuyReviewPhotoAdapter(reviewPhotoList)
        binding.buyRvReviewPhoto.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.buyRvReviewPhoto.layoutManager = layoutManager
    }

}