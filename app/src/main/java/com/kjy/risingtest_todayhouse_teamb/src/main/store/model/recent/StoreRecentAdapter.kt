package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StoreRecentItemListBinding

class StoreRecentAdapter: RecyclerView.Adapter<StoreRecentHolder>() {

    var storeRecentList = mutableListOf<StoreRecentData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreRecentHolder {
        val binding = StoreRecentItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreRecentHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreRecentHolder, position: Int) {
        val recentData = storeRecentList[position]
        holder.setRecentData(recentData)

    }

    override fun getItemCount(): Int {
        return storeRecentList.size
    }
}

class StoreRecentHolder(val binding: StoreRecentItemListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setRecentData(storeRecentData: StoreRecentData) {
        Glide.with(itemView)
            .load(storeRecentData.storeRecentImage)
            .into(binding.storeIvRecent)
        binding.storeTvRecentBrand.text = storeRecentData.storeRecentBrandTitle
        binding.storeTvRecentTitle.text = storeRecentData.storeRecentGoodsTitle
        binding.storeTvRecentPercent.text = storeRecentData.storeRecentPercent
        binding.storeTvRecentPrice.text = storeRecentData.storeRecentPrice.toString()
        binding.storeTvRecentReviewScore.text = storeRecentData.storeRecentReviewScore
        binding.storeTvRecentReviewCount.text = storeRecentData.storeRecentReviewCount.toString()
    }
}