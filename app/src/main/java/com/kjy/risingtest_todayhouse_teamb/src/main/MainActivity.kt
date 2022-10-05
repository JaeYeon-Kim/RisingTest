package com.kjy.risingtest_todayhouse_teamb.src.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import com.kakao.sdk.common.util.Utility
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityMainBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.home.HomeFragment
import com.kjy.risingtest_todayhouse_teamb.src.main.move.MoveFragment
import com.kjy.risingtest_todayhouse_teamb.src.main.mypage.MypageFragment
import com.kjy.risingtest_todayhouse_teamb.src.main.store.StoreFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    // 플로팅 액션 버튼의 상태 지정
    // 기본값 닫혀있음
    private var isFabOpen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 카카오 로그인 연동에 필요한 KeyHASH 값을 구한다.
//        val keyHash = Utility.getKeyHash(this)
//        Log.d("Hash", keyHash)


        // 바텀 네비게이션 테마색 변경을 막아줌
        showBottomIcon()
        // 메인 액티비티 진입시 맨 처음 나오는 커스텀 다이얼로그 띄워주기
        showMainDialog()

        binding.mainBtnFloating.setOnClickListener {
            animationFab()
            val dialog = CustomDialogFloat(this)
            dialog.showDialogFloating()
        }


        supportFragmentManager.beginTransaction().replace(R.id.main_layout_frame, HomeFragment())
            .commitAllowingStateLoss()

        // 메인 액티비티에 프래그먼트 연결
        binding.mainNavBottom.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.main_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_layout_frame, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.main_nav_myPage -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_layout_frame, MypageFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.main_nav_store -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_layout_frame, StoreFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.main_nav_move -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_layout_frame, MoveFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            // 첫 시작시 프래그먼트를 홈 화면으로 보여줌
            selectedItemId = R.id.main_nav_home
        }

    }


    // 아이콘이 테마색으로 변경되는 것을 막아줌
    private fun showBottomIcon() {
        binding.mainNavBottom.itemIconTintList = null
    }

    // 커스텀 다이얼로그 띄워주기
    private fun showMainDialog() {
        val dialog = CustomDialog(this)
        dialog.showDialog()
    }

    // 플로팅 버튼 애니메이션 구현하기
    private fun animationFab() {
        if (isFabOpen) {
            ObjectAnimator.ofFloat(binding.mainBtnFloating, View.ROTATION, 45f, 0f)
                .apply { start() }
        } else {
            ObjectAnimator.ofFloat(binding.mainBtnFloating, View.ROTATION, 0f, 45f)
                .apply { start() }
        }

        isFabOpen = !isFabOpen
    }

}