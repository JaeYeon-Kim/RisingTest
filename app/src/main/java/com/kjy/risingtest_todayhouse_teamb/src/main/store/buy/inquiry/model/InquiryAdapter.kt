package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.model

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kjy.risingtest_todayhouse_teamb.databinding.InquiryListBinding
import java.text.SimpleDateFormat

class InquiryAdapter: RecyclerView.Adapter<InquiryHolder>() {

    var inquiryList = ArrayList<ResultInquiry>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InquiryHolder {
        val binding = InquiryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InquiryHolder(binding)
    }

    override fun onBindViewHolder(holder: InquiryHolder, position: Int) {
        val inquiryData = inquiryList[position]
        holder.setInquiry(inquiryData)
    }

    override fun getItemCount(): Int {
        Log.d("문의 액티비티 어댑터 사이즈!!", "${inquiryList.size}")
        return inquiryList.size
    }
}

class InquiryHolder(val binding: InquiryListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setInquiry(inquiryItem: ResultInquiry) {
        binding.inquiryTvNickname.text = inquiryItem.nickname
        binding.inquiryTvQuestion.text = inquiryItem.questionText
        binding.inquiryTvAnswer.text = inquiryItem.answerText
        binding.inquiryTvQuestionDate.text = inquiryItem.questionDate
        if(inquiryItem.answerProgress == 0) {
            binding.inquiryTvAnswerProgress.text = "미답변"
        }else if(inquiryItem.answerProgress == 1) {
            binding.inquiryTvAnswerProgress.text = "답변완료"
        }
        if(inquiryItem.secret == 1) {
            binding.inquiryTvQuestion.text = "비밀글입니다."
            binding.inquiryTvAnswer.text = "비밀글입니다."
        }
        binding.inquiryTvType.text = inquiryItem.type
    }
}