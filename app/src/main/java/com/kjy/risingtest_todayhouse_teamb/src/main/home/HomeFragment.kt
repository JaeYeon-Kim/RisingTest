package com.kjy.risingtest_todayhouse_teamb.src.main.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseFragment
import com.kjy.risingtest_todayhouse_teamb.databinding.FragmentHomeBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.home.homeparty.HomepartyFragment
import com.kjy.risingtest_todayhouse_teamb.src.main.home.photo.FragmentAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.home.photo.PhotoFragment
import com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.PopularFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // 프래그먼트 목록 생성
        val fragmentList = listOf(PopularFragment(), PhotoFragment(), HomepartyFragment())
        // 어댑터 생성후 프래그먼트 목록 저장
        val adapter = FragmentAdapter(requireActivity())
        adapter.fragmentList = fragmentList
        // 뷰페이저에 어댑터 적용
        binding.homeVp.adapter = adapter

        // 탭 레이아웃 리스트 생성
        val tabTitles = listOf("인기", "팔로잉", "사진", "집들이", "노하우", "전문가집들이", "질문과답변")

        TabLayoutMediator(binding.homeTabLayout, binding.homeVp)  { tab, position ->
            tab.text = tabTitles[position]

        }.attach()

    }

    // 메뉴 생성
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_toolbar_menu, menu)
    }

}