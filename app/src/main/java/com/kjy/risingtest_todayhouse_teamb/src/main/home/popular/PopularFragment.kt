package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular

import android.annotation.SuppressLint
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
    private var countBanner = 5
    // 현재 위치를 지정
    private var currentPosition = Int.MAX_VALUE / 2


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
                @SuppressLint("SetTextI18n")
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.popularTvCurrentBanner.text = "${(position % 5) + 1}"
                }
            })
        }
    }

    private fun popularMainRv() {
        val categoryMainList = arrayListOf<PopularMainData>(
            PopularMainData(R.drawable.popular_category_shopping, "쇼핑하기"),
            PopularMainData(R.drawable.popular_category_delivery, "빠른배송"),
            PopularMainData(R.drawable.popular_category_homeparty, "N평집들이"),
            PopularMainData(R.drawable.popular_category_place, "공간별사진"),
            PopularMainData(R.drawable.popular_category_remodel, "리모델링"),
            PopularMainData(R.drawable.popular_category_move, "쉬운이사"),
            PopularMainData(R.drawable.popular_category_today, "오늘의딜"),
            PopularMainData(R.drawable.popular_category_hobby, "취향의발견"),
            PopularMainData(R.drawable.popular_category_free, "매일0원딜"),
            PopularMainData(R.drawable.popular_category_season, "시즌특가")
        )
        binding.popularRvCategoryMain.adapter = PopularMainAdapter(categoryMainList)
        val layoutManager = GridLayoutManager(requireContext(), 5)
        binding.popularRvCategoryMain.layoutManager = layoutManager

    }

    private fun popularPager() {
        var popularPagerList = arrayListOf<PopularPagerData>(
            PopularPagerData(R.drawable.store_viewpager_image_1),
            PopularPagerData(R.drawable.store_viewpager_image_2),
            PopularPagerData(R.drawable.store_viewpager_image_3),
            PopularPagerData(R.drawable.store_viewpager_image_4),
            PopularPagerData(R.drawable.store_viewpager_image_1)
        )
        val adapter = PopularPagerAdapter(popularPagerList)
        binding.popularVp.adapter = adapter
        binding.popularVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}