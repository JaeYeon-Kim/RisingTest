package com.kjy.risingtest_todayhouse_teamb.src.main.store


import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentStoreBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.CategoryData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.GoodsCategoryAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.GoodsCategoryData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.StoreCategoryAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager.StorePagerAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager.StorePagerData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.popular.StorePopularAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.popular.StorePopularData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.recent.StoreRecentAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.recent.StoreRecentData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.relative.StoreRelativeAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.relative.StoreRelativeData


class StoreFragment : BaseFragment<FragmentStoreBinding>(FragmentStoreBinding::bind, R.layout.fragment_store){

    // 스토어 프래그먼트 메인 카테고리 리스트
    private var categoryList = mutableListOf<CategoryData>()

    // 스토어 프래그먼트 상품 카테고리 리스트
    private var goodsList = mutableListOf<GoodsCategoryData>()

    // 광고 뷰페이저 리스트
    private var storePagerList = mutableListOf<StorePagerData>()

    // 스토어 프래그먼트의 최근 본 상품 리스트
    private var storeRecentList = mutableListOf<StoreRecentData>()

    // 스토어 프래그먼트의 내가 본 상품의 연관상품 리스트
    private var storeRelativeList = mutableListOf<StoreRelativeData>()

    // 스토어 프래그먼트의 인기상품 리스트
    private var storePopularList = mutableListOf<StorePopularData>()

    private lateinit var listener: ViewTreeObserver.OnScrollChangedListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        // 스토어 프래그먼트 최근 본 상품 연동
        storeRecentRecycler()

        // 스토어 프래그먼트 내가 본 상품의 연관상품 연동
        storeRelativeRecycler()

        // 스토어 프래그먼트 인기 상품 연동
        storePopularRecycler()
    }

    override fun onStop() {
        super.onStop()
        binding.storeSv.viewTreeObserver.removeOnScrollChangedListener(listener)
    }

    // 스토어 프래그먼트의 메인 카테고리 리사이클러뷰 구현
    private fun categoryRecycler() {
        var adapter = StoreCategoryAdapter()
        binding.storeRvCategory.adapter = adapter
        categoryList.apply {
            add(CategoryData(R.drawable.store_category_kitchen, "주방필템"))
            add(CategoryData(R.drawable.store_category_best, "베스트"))
            add(CategoryData(R.drawable.store_category_today, "오늘의딜"))
            add(CategoryData(R.drawable.store_category_goods, "오!굿즈"))
            add(CategoryData(R.drawable.store_category_quick, "빠른배송"))
            add(CategoryData(R.drawable.store_category_premium, "프리미엄"))
            add(CategoryData(R.drawable.store_category_rippermarket, "리퍼마켓"))
            add(CategoryData(R.drawable.store_category_new, "신상특가"))
            add(CategoryData(R.drawable.store_category_foodmarket, "푸드마켓"))
            add(CategoryData(R.drawable.store_category_special, "기획전"))
        }
        adapter.categoryList = categoryList
        val layoutManager = GridLayoutManager(requireContext(), 5)
        binding.storeRvCategory.layoutManager = layoutManager

    }

    private fun categoryGoodsRecycler() {
        var adapter = GoodsCategoryAdapter()
        binding.storeRvCategoryGoods.adapter = adapter
        goodsList.apply {
            add(GoodsCategoryData(R.drawable.store_category_goods_image_1))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_2))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_3))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_4))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_5))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_6))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_7))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_8))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_9))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_10))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_11))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_12))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_13))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_14))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_15))
            add(GoodsCategoryData(R.drawable.store_category_goods_image_16))

        }
        adapter.goodsList = goodsList
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false )
        binding.storeRvCategoryGoods.layoutManager = layoutManager

    }

    private fun storeAdViewpager() {
        val adapter = StorePagerAdapter()
        binding.storeViewPager.adapter = adapter
        binding.storeIndicatorVp.attachTo(binding.storeViewPager)
        storePagerList.apply {
            add(StorePagerData(R.drawable.store_viewpager_image_1))
            add(StorePagerData(R.drawable.store_viewpager_image_2))
            add(StorePagerData(R.drawable.store_viewpager_image_3))
            add(StorePagerData(R.drawable.store_viewpager_image_4))
        }
        adapter.storePagerList = storePagerList
        binding.storeViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun storeRecentRecycler() {
        val adapter = StoreRecentAdapter()
        binding.storeRvRecent.adapter = adapter
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_1, "스타일링홈", "test침대", "60%",
                    30000, "4.8", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_2, "스타일링홈", "test침대", "60%",
                30000, "4.9", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_3, "스타일링홈", "test침대", "60%",
                50000, "4.6", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_4, "스타일링홈", "test침대", "60%",
                130000, "4.3", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_5, "스타일링홈", "test침대", "60%",
                130000, "4.2", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_6, "스타일링홈", "test침대", "60%",
                290000, "4.1", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_7, "스타일링홈", "test침대", "60%",
                150000, "4.8", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_8, "스타일링홈", "test침대", "60%",
                230000, "4.9", 15000))
        }
        storeRecentList.apply {
            add(StoreRecentData(R.drawable.store_testimage_9, "스타일링홈", "test침대", "60%",
                130000, "5.0", 15000))
        }
        adapter.storeRecentList = storeRecentList
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.storeRvRecent.layoutManager = layoutManager
    }

    private fun storeRelativeRecycler() {
        val adapter = StoreRelativeAdapter()
        binding.storeRvRelative.adapter = adapter
        storeRelativeList.apply {
            add(StoreRelativeData(R.drawable.store_testimage_1, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500 ))
            add(StoreRelativeData(R.drawable.store_testimage_2, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500 ))
            add(StoreRelativeData(R.drawable.store_testimage_3, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500 ))
            add(StoreRelativeData(R.drawable.store_testimage_4, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500 ))
        }
        adapter.storeRelativeList = storeRelativeList
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.storeRvRelative.layoutManager = layoutManager
    }

    private fun storePopularRecycler() {
        val adapter = StorePopularAdapter()
        binding.storeRvPopular.adapter = adapter
        storePopularList.apply {
            add(StorePopularData(R.drawable.store_testimage_1, "오트밀하우스",
                    "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                    , "4.8", 1500))
            add(StorePopularData(R.drawable.store_testimage_2, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500))
            add(StorePopularData(R.drawable.store_testimage_3, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500))
            add(StorePopularData(R.drawable.store_testimage_4, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500))
            add(StorePopularData(R.drawable.store_testimage_5, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500))
            add(StorePopularData(R.drawable.store_testimage_6, "오트밀하우스",
                "데이지 LED 조명 3단 벙커 수납 침대 SS/Q", "40%", 40000
                , "4.8", 1500))
        }
        adapter.storePopularList = storePopularList
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.storeRvPopular.layoutManager = layoutManager
    }

}