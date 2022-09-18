package com.kjy.risingtest_todayhouse_teamb.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityMainBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.home.HomeFragment
import com.kjy.risingtest_todayhouse_teamb.src.main.mypage.MypageFragment
import com.kjy.risingtest_todayhouse_teamb.src.main.store.StoreFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바텀 네비게이션 테마색 변경을 막아줌
        showBottomIcon()
        // 커스텀 다이얼로그 띄워주기
        showMainDialog()


        supportFragmentManager.beginTransaction().replace(R.id.main_layout_frame, HomeFragment()).commitAllowingStateLoss()

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
}