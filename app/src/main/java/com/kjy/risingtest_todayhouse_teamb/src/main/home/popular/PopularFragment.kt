package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentPopularBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model.*
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager.StorePagerData


// 탭 레이아웃의 인기 탭
class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::bind, R.layout.fragment_popular) {

    // 배너 개수
    private var countBanner = 5
    // 현재 위치를 지정
    private var currentPosition = Int.MAX_VALUE / 2

    // 첫번째 리사이클러뷰 어댑터
    val firstAdapter = PopularFirstAdapter()

    // 두번째 리사이클러뷰 어댑터
    val secondAdapter = PopularSecondAdapter()

    // 세번째 리사이클러뷰 어댑터
    val thirdAdapter = PopularThirdAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularMainRv()

        popularPager()

        firstPopularRecycler()

        secondPopularRecycler()

        thirdPopularRecycler()


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

    private fun firstPopularRecycler() {
        var popularFirstList = arrayListOf<PopularFirstData>(
            PopularFirstData(R.drawable.popular_rv_1, "푸른 색감의 4평 방 3가지 가구로 공간을 분리했어요."),
            PopularFirstData(R.drawable.popular_rv_2, "키덜트 룸 아기자기한 소품 가득!"),
            PopularFirstData(R.drawable.popular_rv_3, "작은 집을 넓어 보이게\n 디자이너의 리모델링"),
            PopularFirstData(R.drawable.popular_rv_4, "귀여움 천국 프로자취러의 맥시멀 변화 기록")
        )
        firstAdapter.popularFirstList = popularFirstList
        binding.popularRvContent1.adapter = firstAdapter
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.popularRvContent1.layoutManager = layoutManager
    }

    private fun secondPopularRecycler() {
        var popularSecondList = arrayListOf<PopularSecondData>(
            PopularSecondData(R.drawable.popular_rv_5, "다이소템으로 한 번에 해결 냉장고 공간별 수납템13"),
            PopularSecondData(R.drawable.popular_rv_6, "이런 것도 있어?! 홈트레이닝 입문용 찐 추천템10"),
            PopularSecondData(R.drawable.popular_rv_7, "무인양품 직원의 단란한 6평 오피스텔"),
            PopularSecondData(R.drawable.popular_rv_8, "이 돈으로 이런 효과를! 우리집 가성비 대장 살림템 6")
        )
        secondAdapter.popularSecondList = popularSecondList
        binding.popularRvContent2.adapter = secondAdapter
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.popularRvContent2.layoutManager = layoutManager
    }

    private fun thirdPopularRecycler() {
        var popularThirdList = arrayListOf<PopularThirdData>(
            PopularThirdData(R.drawable.popular_rv_9, "이렇게 많다고? 다꾸러를\n 위한 12종 스티커 정리법"),
            PopularThirdData(R.drawable.popular_rv_10, "우리집을 빈티지숍처럼\n애정하는 리얼 빈티지 소품 5"),
            PopularThirdData(R.drawable.popular_rv_11, "그릇사랑단의 최애 그릇은?\n즐거운수집생활"),
            PopularThirdData(R.drawable.popular_rv_12, "디즈니덕후 모여라\n빈티지토이 최애템부터...")
        )
        thirdAdapter.popularThirdList = popularThirdList
        binding.popularRvContent3.adapter = thirdAdapter
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.popularRvContent3.layoutManager = layoutManager
    }
}