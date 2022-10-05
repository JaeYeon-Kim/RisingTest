package com.kjy.risingtest_todayhouse_teamb.src.main.store


import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentStoreBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.StoreHomeResponse
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.*
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager.StorePagerAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager.StorePagerData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.popular.StorePopularAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.recent.StoreRecentAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.relative.StoreRelativeAdapter


class StoreFragment : BaseFragment<FragmentStoreBinding>(FragmentStoreBinding::bind, R.layout.fragment_store), StoreFragmentInterface{

    // 광고 뷰페이저 리스트
    private var storePagerList = mutableListOf<StorePagerData>()

    private lateinit var listener: ViewTreeObserver.OnScrollChangedListener


    private val recentAdapter = StoreRecentAdapter()

    private val relativeAdapter = StoreRelativeAdapter()

    private val popularAdapter = StorePopularAdapter()

    private val pagerAdapter = StorePagerAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 스토어 홈 메인의 리사이클러뷰들을 불러옴
        StoreService(this).tryGetHomeMain()

        // 스토어 홈 메인의 광고 뷰페이저 이미지 들을 불러옴
        StoreService(this).tryGetHomeAd()

        // 스와이프 리프레시 레이아웃 기능 넣기
        // false로 해주어야 새로고침 아이콘이 사라짐
        binding.storeLayoutRefresh.setOnRefreshListener {
            binding.storeLayoutRefresh.isRefreshing = false
        }

        listener = ViewTreeObserver.OnScrollChangedListener {
            binding.storeLayoutRefresh.isEnabled = (binding.storeSv.scrollY == 0)
        }

        // 스토어 프래그먼트 메인 카테고리 리사이클러뷰
        categoryRecycler()

        // 스토어 프래그먼트의 가로형 카테고리 리사이클러뷰
        categoryGoodsRecycler()

        // 스토어 프래그먼트 광고 뷰페이저
        storeAdViewpager()


        // 스토어 프래그먼트 내가 본 상품의 연관상품 연동
        storeRelativeRecycler()

        // 스토어 프래그먼트 인기 상품 연동
        storePopularRecycler()

        // 최근 본 상품
        storeRecentRecycler()

    }

    override fun onStop() {
        super.onStop()
        binding.storeSv.viewTreeObserver.removeOnScrollChangedListener(listener)
    }

    // 스토어 프래그먼트의 메인 카테고리 리사이클러뷰 구현
    private fun categoryRecycler() {
        val categoryList = arrayListOf<CategoryData>(
            CategoryData(R.drawable.store_category_kitchen, "주방필템"),
            CategoryData(R.drawable.store_category_best, "베스트"),
            CategoryData(R.drawable.store_category_today, "오늘의딜"),
            CategoryData(R.drawable.store_category_goods, "오!굿즈"),
            CategoryData(R.drawable.store_category_quick, "빠른배송"),
            CategoryData(R.drawable.store_category_premium, "프리미엄"),
            CategoryData(R.drawable.store_category_rippermarket, "리퍼마켓"),
            CategoryData(R.drawable.store_category_new, "신상특가"),
            CategoryData(R.drawable.store_category_foodmarket, "푸드마켓"),
            CategoryData(R.drawable.store_category_special, "기획전")
        )
        var adapter = StoreCategoryAdapter(categoryList)
        binding.storeRvCategory.adapter = adapter
        val layoutManager = GridLayoutManager(requireContext(), 5)
        binding.storeRvCategory.layoutManager = layoutManager

    }

    private fun categoryGoodsRecycler() {
        val goodsList = arrayListOf<GoodsCategoryData>(
            GoodsCategoryData(R.drawable.store_category_goods_image_1),
            GoodsCategoryData(R.drawable.store_category_goods_image_2),
            GoodsCategoryData(R.drawable.store_category_goods_image_3),
            GoodsCategoryData(R.drawable.store_category_goods_image_4),
            GoodsCategoryData(R.drawable.store_category_goods_image_5),
            GoodsCategoryData(R.drawable.store_category_goods_image_6),
            GoodsCategoryData(R.drawable.store_category_goods_image_7),
            GoodsCategoryData(R.drawable.store_category_goods_image_8),
            GoodsCategoryData(R.drawable.store_category_goods_image_9),
            GoodsCategoryData(R.drawable.store_category_goods_image_10),
            GoodsCategoryData(R.drawable.store_category_goods_image_11),
            GoodsCategoryData(R.drawable.store_category_goods_image_12),
            GoodsCategoryData(R.drawable.store_category_goods_image_13),
            GoodsCategoryData(R.drawable.store_category_goods_image_14),
            GoodsCategoryData(R.drawable.store_category_goods_image_15),
            GoodsCategoryData(R.drawable.store_category_goods_image_16)
        )
        var adapter = GoodsCategoryAdapter(goodsList)
        binding.storeRvCategoryGoods.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.storeRvCategoryGoods.layoutManager = layoutManager
    }


    private fun storeAdViewpager() {
        binding.storeViewPager.adapter = pagerAdapter
        binding.storeIndicatorVp.attachTo(binding.storeViewPager)
        binding.storeViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun storeRecentRecycler() {
        binding.storeRvRecent.adapter = recentAdapter
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.storeRvRecent.layoutManager = layoutManager
    }


    private fun storeRelativeRecycler() {
        binding.storeRvRelative.adapter = relativeAdapter
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.storeRvRelative.layoutManager = layoutManager

    }

    private fun storePopularRecycler() {

        binding.storeRvPopular.adapter = popularAdapter
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.storeRvPopular.layoutManager = layoutManager
    }

    // 요청을 성공적으로 받아왔을때
    override fun onGetHomeMainSuccess(response: StoreHomeResponse) {
        if(response.isSuccess) {
            Log.d("스토어프래그먼트 ", "${response.result}")
            recentAdapter.storeRecentList = response.result
            recentAdapter.notifyDataSetChanged()

            Log.d("연관상품", "${response.result}")
            relativeAdapter.storeRelativeList = response.result
            relativeAdapter.notifyDataSetChanged()

            Log.d("인기상품", "${response.message}")
            popularAdapter.storePopularList = response.result
            popularAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetHomeMainFailure(message: String) {
        showCustomToast("오류 : $message")
    }

    // 스토어 홈의 광고 뷰페이저 이미지를 받아오는 API 에 대한 호출
    override fun onGetHomeAdSuccess(response: StoreAdResponse) {
        if(response.isSuccess) {
            pagerAdapter.storePagerList = response.result
            pagerAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetHomeAdFailure(message: String) {
        showCustomToast("오류 : $message")
    }

}