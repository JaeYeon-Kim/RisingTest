package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular

import android.os.Bundle
import android.view.View
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentPopularBinding


// 탭 레이아웃의 인기 탭
class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::bind, R.layout.fragment_popular) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}