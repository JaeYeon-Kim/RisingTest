package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.pay.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.PayOrderListBinding

class PayOrderAdapter: RecyclerView.Adapter<PayOrderHolder>() {

    var payOrderList = ArrayList<PayOrderData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayOrderHolder {
        val binding = PayOrderListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PayOrderHolder(binding)
    }

    override fun onBindViewHolder(holder: PayOrderHolder, position: Int) {
        val orderData = payOrderList[position]
        holder.setOrder(orderData)
    }

    override fun getItemCount(): Int {
        return payOrderList.size
    }
}

class PayOrderHolder(val binding: PayOrderListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setOrder(payOrderData: PayOrderData) {
        binding.orderStoreTitle.text = payOrderData.storeTitle.toString()
        binding.orderGoodsTitle.text = payOrderData.goodsTitle
        binding.orderGoodsOption.text = payOrderData.goodsOption
    }

}
