package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentPopularBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model.PopularMainAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model.PopularMainData


// 탭 레이아웃의 인기 탭
class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::bind, R.layout.fragment_popular) {

    // 인기 탭의 메인 카테고리의 데이터 클래스를 담는 리스트
    var categoryMainList = mutableListOf<PopularMainData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularMainRv()
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
}