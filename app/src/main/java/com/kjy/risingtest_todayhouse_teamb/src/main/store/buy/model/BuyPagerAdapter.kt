package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.BuyPagerListBinding

class BuyPagerAdapter: RecyclerView.Adapter<BuyPagerHolder>() {

    var buyPagerList = mutableListOf<BuyPagerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyPagerHolder {
        val binding = BuyPagerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyPagerHolder, position: Int) {
        val pagerData = buyPagerList[position]
        holder.setBuyPager(pagerData)
    }

    override fun getItemCount(): Int {
        return buyPagerList.size
    }
}

class BuyPagerHolder(val binding: BuyPagerListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setBuyPager(buyPagerData: BuyPagerData) {
        Glide.with(itemView)
            .load(buyPagerData.uri)
            .into(binding.buyIvPager)
    }
}