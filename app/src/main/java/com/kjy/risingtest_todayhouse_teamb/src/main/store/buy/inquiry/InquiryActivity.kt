package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityInquiryBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.edit.InquiryEditActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model.InquiryAdapter
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model.InquiryResponse

class InquiryActivity : BaseActivity<ActivityInquiryBinding>(ActivityInquiryBinding::inflate), InquiryActivityInterface {

    private val inquiryAdapter = InquiryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 문의 API 호출 하기
        InquiryService(this).tryGetInquiry()

        inquiryRecycler()

        binding.inquiryBtnEdit.setOnClickListener {
            val intent = Intent(this, InquiryEditActivity::class.java)
            startActivity(intent)
        }
    }

    private fun inquiryRecycler() {
        binding.inquiryRv.adapter = inquiryAdapter
        val layoutManager = LinearLayoutManager(this)
        binding.inquiryRv.layoutManager = layoutManager
    }

    // 상품 문의 불러오기
    override fun onGetInquirySuccess(response: InquiryResponse) {
        Log.d("문의 배열 찍어보기!!!", "${response.result}")
        if(response.isSuccess) {
            inquiryAdapter.inquiryList = response.result
            inquiryAdapter.notifyDataSetChanged()
        }
    }

    override fun onGetInquiryFailure(message: String) {
        Log.e("문의 액티비티 오류!!", "$message")
        Log.e("문의 액티비티", "$message")
    }


}