package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentPopularBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model.PopularMainAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model.PopularMainData
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model.PopularPagerAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model.PopularPagerData
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager.StorePagerData


// 탭 레이아웃의 인기 탭
class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::bind, R.layout.fragment_popular) {

    // 배너 개수
    private var countBanner = 4
    // 현재 위치를 지정
    private var currentPosition = Int.MAX_VALUE / 2

    // 인기 탭의 메인 카테고리의 데이터 클래스를 담는 리스트
    var categoryMainList = mutableListOf<PopularMainData>()

    // 인기 탭의 뷰페이저 데이터 클래스를 담는 리슽
    var popularPagerList = mutableListOf<PopularPagerData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularMainRv()

        popularPager()


        // 현재 위치를 지정해준다.
        binding.popularVp.setCurrentItem(currentPosition, false)
        // 토탈 배너 갯수를 지정해줌
        binding.popularTvTotalBanner.text = countBanner.toString()

        // 현재 몇번째 배너인지 보여주는 변경 리스너
        binding.popularVp.apply {
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.popularTvCurrentBanner.text = "${(position % 4) + 1}"
                }
            })
        }
    }

    private fun popularMainRv() {
        var adapter = PopularMainAdapter()
        binding.popularRvCategoryMain.adapter = adapter
        categoryMainList.apply {
            add(PopularMainData(R.drawable.popular_category_shopping, "쇼핑하기"))
            add(PopularMainData(R.drawable.popular_category_delivery, "빠른배송"))
            add(PopularMainData(R.drawable.popular_category_homeparty, "N평집들이"))
            add(PopularMainData(R.drawable.popular_category_place, "공간별사진"))
            add(PopularMainData(R.drawable.popular_category_remodel, "리모델링"))
            add(PopularMainData(R.drawable.popular_category_move, "쉬운이사"))
            add(PopularMainData(R.drawable.popular_category_today, "오늘의딜"))
            add(PopularMainData(R.drawable.popular_category_hobby, "취향의발견"))
            add(PopularMainData(R.drawable.popular_category_free, "매일0원딜"))
            add(PopularMainData(R.drawable.popular_category_season, "시즌특가"))
        }
        adapter.categoryMainList = categoryMainList
        val layoutManager = GridLayoutManager(requireContext(), 5)
        binding.popularRvCategoryMain.layoutManager = layoutManager

    }

    private fun popularPager() {
        val adapter = PopularPagerAdapter()
        binding.popularVp.adapter = adapter
        popularPagerList.apply {
            add(PopularPagerData(R.drawable.store_viewpager_image_1))
            add(PopularPagerData(R.drawable.store_viewpager_image_2))
            add(PopularPagerData(R.drawable.store_viewpager_image_3))
            add(PopularPagerData(R.drawable.store_viewpager_image_4))
        }
        adapter.popularPagerList = popularPagerList
        binding.popularVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}