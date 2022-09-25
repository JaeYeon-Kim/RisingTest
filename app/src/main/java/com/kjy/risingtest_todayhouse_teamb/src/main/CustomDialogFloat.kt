package com.kjy.risingtest_todayhouse_teamb.src.main

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.WindowManager
import com.kjy.risingtest_todayhouse_teamb.R

// 메인 액티비티에서 플로팅 액션 버튼 클릭시 나오는 다이얼로그
class CustomDialogFloat(context: Context) {
    private val dialog = Dialog(context)

    fun showDialogFloating() {
        dialog.setContentView(R.layout.main_floating_dialog)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                 WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)          // 뒤 배경 검정색 막기
        dialog.window!!.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)

        // 애니메이션 설정
        dialog.window!!.attributes.windowAnimations = R.style.FloatAnimationPopupStyle

        // UI 하단 정렬
        dialog.window!!.setGravity(Gravity.BOTTOM)


        dialog.show()
    }
}