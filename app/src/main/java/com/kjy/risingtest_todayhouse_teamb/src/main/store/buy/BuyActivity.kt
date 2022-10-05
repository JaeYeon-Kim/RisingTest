package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityBuyBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.change.ReturnChangeActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.InquiryActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model.*
import com.kjy.risingtest_todayhouse_teamb.util.BuyBottomSheet
import java.text.DecimalFormat

class BuyActivity : BaseActivity<ActivityBuyBinding>(ActivityBuyBinding::inflate), BuyActivityInterface{

    // 상품 구매 액티비티 - 유저 스타일링샷 데이터를 담는 리스트
    private var buyUserList = mutableListOf<BuyUserData>()

    // 리뷰 어댑터
    private val commentAdapter = ReviewCommentAdapter()


    // 상품 정보 어댑터
    private val infoAdapter = BuyGoodsInfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 리뷰 서비스에서 요청 함
        BuyService(this).tryGetReview()

        // 상세 이미지들 가져옴
        BuyService(this).tryGetGoodsInfo()

        // 디테일 정보들 가져옴
        BuyService(this).tryGetDetail()

        // 디테일 정보들 2 가져옴
        BuyService(this).tryGetAdd()


        binding.buyBtnBack.setOnClickListener {
            onBackPressed()
            finish()
        }

        // 배송 교환 환불 버튼 킅릭시 배송/교환/환불 페이지로 이동
        binding.buyLayoutReturn.setOnClickListener {
            val intent = Intent(this, ReturnChangeActivity::class.java)
            startActivity(intent)
        }

        // 문의 버튼 클릭시 문의 페이지로 이동
        binding.buyLayoutQuestion.setOnClickListener {
            val intent = Intent(this, InquiryActivity::class.java)
            startActivity(intent)
        }

        // 상품 구매 액티비티 뷰페이저
        buyPager()

        // 유저 스타일링 리사이클러뷰
        buyUserRecycler()

        // 상품 정보 리사이클러뷰
        buyGoodsInfoRecycler()

        // 상품 리뷰 사진들 리사이클러뷰
        buyReviewPhotoRecycler()

        // 구매 액티비티의 리뷰 리사이클러뷰
        reviewCommentRecycler()


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
        // 구매하기 버튼 클릭시 띄우는 다이얼로그 호출
        binding.buyBtnBuy.setOnClickListener {
            val buyDialog = BuyBottomSheet()
            buyDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialogTheme)
            buyDialog.show(supportFragmentManager, BuyBottomSheet.TAG)
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun reviewCommentRecycler() {
        binding.buyRvReviewComment.adapter = commentAdapter
        val layoutManager = LinearLayoutManager(this)
        binding.buyRvReviewComment.layoutManager = layoutManager
    }

    private fun buyPager() {
        val buyPagerList = arrayListOf<BuyPagerData>(
                    BuyPagerData(R.drawable.buy_test_image_1),
                    BuyPagerData(R.drawable.buy_test_image_2),
                    BuyPagerData(R.drawable.buy_test_image_3),
                    BuyPagerData(R.drawable.buy_test_image_4))

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
        binding.buyRvGoodsInfo.adapter = infoAdapter
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

    // 구매 액티비티의 리뷰 불러오기
    override fun onGetReviewSuccess(response: ReviewResponse) {
        if(response.isSuccess) {
            Log.d("구매액티비티 리뷰", "${response.result}")
            commentAdapter.reviewCommentList = response.result
            commentAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetReviewFailure(message: String) {
        Log.e("구매액티비티 리뷰", "$message")
    }

    override fun onGetGoodsInfoSuccess(response: InfoResponse) {
        if(response.isSuccess) {
            infoAdapter.goodsInfoList = response.result
            infoAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetGoodsInfoFailure(message: String) {
        Log.e("구매 액티비티 상세이미지", "$message")
    }

    // 상세 정보들 가져오기
    override fun onGetDetailSuccess(response: DetailResponse) {

        Log.d("상세정보들 가져오기", "${response.result}")

        val decFormat = DecimalFormat("#,###")

        for (Store in response.result) {
            binding.buyTvMainTitle.text = Store.goodsTitle
            binding.buyTvStoreTitle.text = Store.storeTitle
            binding.buyTvStoreTitle2.text = Store.storeTitle
            binding.buyTvGoodsTitle.text = Store.goodsTitle
            binding.buyTvReviewCount.text = Store.reviewCount.toString()
            binding.buyTvDcPercent.text = Store.percentRate.toString().plus("%")
            binding.buyTvOgPrice.paintFlags = binding.buyTvOgPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            binding.buyTvOgPrice.text = decFormat.format(Store.originPrice)
            val dcPrice = (Store.originPrice - ((Store.originPrice / 100) * Store.percentRate))
            binding.buyTvDcPrice.text = decFormat.format(dcPrice)
            binding.buyTvDeliveryPrice.text = Store.deliveryPrice.toString()
            binding.buyTvTotalReview.text = Store.reviewCount.toString()
        }
    }

    override fun onGetDetailFailure(message: String) {
        Log.e("상세정보들 가져오기", "$message")
    }

    override fun onGetAddSuccess(response: AddResponse) {
        binding.buyTvDeliveryMethod.text = response.result.deliveryMethod
        binding.buyTvScrapCount.text = response.result.scrapCount.toString()
    }

    override fun onGetAddFailure(message: String) {
        Log.e("상세정보들 가져오기 두번째", "$message")
    }
}