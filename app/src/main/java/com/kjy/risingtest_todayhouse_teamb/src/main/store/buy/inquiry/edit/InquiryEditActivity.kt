package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.kjy.risingtest_todayhouse_teamb.R
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityInquiryEditBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.edit.model.EditAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.edit.model.EditData

class InquiryEditActivity : BaseActivity<ActivityInquiryEditBinding>(ActivityInquiryEditBinding::inflate) {

    val editAdapter = EditAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        editTypeRecycler()

    }

    // 문의 유형 리사이클러뷰
    private fun editTypeRecycler() {
        val editTypeList = arrayListOf<EditData>(
            EditData("상품"),
            EditData("배송"),
            EditData("반품"),
            EditData("교환"),
            EditData("환불"),
            EditData("기타")
        )
        editAdapter.editTypeList = editTypeList
        binding.editRvInquiryType.adapter = editAdapter
        val layoutManager = GridLayoutManager(this, 3)
        binding.editRvInquiryType.layoutManager = layoutManager

    }
}