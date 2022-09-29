package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.PayMethodListBinding

class PayMethodAdapter: RecyclerView.Adapter<PayMethodHolder>() {

    var payMethodList = ArrayList<PayMethodData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayMethodHolder {
        val binding = PayMethodListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PayMethodHolder(binding)
    }

    override fun onBindViewHolder(holder: PayMethodHolder, position: Int) {
        val payData = payMethodList[position]
        holder.setPayMethod(payData)
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    // 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    // 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    // setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener: OnItemClickListener


    override fun getItemCount(): Int {
        return payMethodList.size
    }
}

class PayMethodHolder(val binding: PayMethodListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setPayMethod(payMethodData: PayMethodData) {
        Glide.with(itemView)
            .load(payMethodData.uri)
            .into(binding.ivPayMethod)
        binding.tvPayMethodTitle.text = payMethodData.payMethodTitle
        binding.tvPayMethodBenefit.text = payMethodData.payBenefit
    }
}