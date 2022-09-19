package com.kjy.risingtest_todayhouse_teamb.src.main.home.photo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


// 프래그먼트를 뷰페이저에 보여주기 위한 프래그먼트 어댑터
class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    var fragmentList = listOf<Fragment>()

    // 어댑터가 화면에 보여줄 전체 프래그먼트 갯수 반환
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    // 현재 페이지의 position이 파라미터로 넘어옴
    // postion에 해당하는 위치의 프래그먼트 생성후 반환
    // 페이지가 요청 될때 getItem으로 요청되는 페이지의 position 값 넘어옴
    // position 값을 이용해서 프래그먼트 목록에서 해당 position에 있는 프래그먼트 1개를 리턴해줌.
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}