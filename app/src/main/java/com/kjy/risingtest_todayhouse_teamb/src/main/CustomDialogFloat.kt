package com.kjy.risingtest_todayhouse_teamb.src.main

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import com.kjy.risingtest_todayhouse_teamb.R

// 메인 액티비티에서 플로팅 액션 버튼 클릭시 나오는 다이얼로그
class CustomDialogFloat(context: Context) {
    private val dialog = Dialog(context)

    fun showDialogFloating() {
        dialog.setContentView(R.layout.main_floating_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                    WindowManager.LayoutParams.MATCH_PARENT)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()
    }
}