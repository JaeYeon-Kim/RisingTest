package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.GoodsInfoListBinding

class BuyGoodsInfoAdapter: RecyclerView.Adapter<GoodsInfoHolder>() {

    var goodsInfoList = ArrayList<BuyGoodsInfoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsInfoHolder {

        val binding = GoodsInfoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GoodsInfoHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsInfoHolder, position: Int) {
        val infoData = goodsInfoList[position]
        return holder.setGoodsInfo(infoData)
    }

    override fun getItemCount(): Int {
        return goodsInfoList.size
    }
}

class GoodsInfoHolder(val binding: GoodsInfoListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setGoodsInfo(goodsInfoData: BuyGoodsInfoData) {
        Glide.with(itemView)
            .load(goodsInfoData.uri)
            .into(binding.buyIvGoodsInfo)
    }

}