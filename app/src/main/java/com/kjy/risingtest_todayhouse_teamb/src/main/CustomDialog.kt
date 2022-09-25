package com.kjy.risingtest_todayhouse_teamb.src.main

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.Button
import com.kjy.risingtest_todayhouse_teamb.R

class CustomDialog(context: Context){
    private val dialog = Dialog(context)


    fun showDialog() {
        dialog.setContentView(R.layout.main_dialog_custom)
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                  WindowManager.LayoutParams.MATCH_PARENT)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.AdAnimationPopupStyle       // 다이얼로그 애니메이션
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(true)

        val cancelBtn = dialog.findViewById<Button>(R.id.dialog_btn_cancel)
        val neverBtn = dialog.findViewById<Button>(R.id.dialog_btn_never)
        cancelBtn.setOnClickListener {dialog.dismiss()}
        neverBtn.setOnClickListener {dialog.dismiss()}

        dialog.show()
    }

    // 다이얼로그 이벤트 설정을 위한 리스너
    interface ButtonClickListener {
        fun onClick(text: String)
    }

    private lateinit var onClickListener: ButtonClickListener

    fun setOnClickListener(listener: ButtonClickListener) {
        onClickListener = listener
    }
}