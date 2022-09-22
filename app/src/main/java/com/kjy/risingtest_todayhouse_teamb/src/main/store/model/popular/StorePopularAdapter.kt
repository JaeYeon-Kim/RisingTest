package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StorePopularItemListBinding

class StorePopularAdapter: RecyclerView.Adapter<StorePopularHolder>() {

    var storePopularList = mutableListOf<StorePopularData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorePopularHolder {
        val binding = StorePopularItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorePopularHolder(binding)
    }

    override fun onBindViewHolder(holder: StorePopularHolder, position: Int) {
        val popularData = storePopularList[position]
        holder.setPopularData(popularData)
    }

    override fun getItemCount(): Int {
        return storePopularList.size
    }
}

class StorePopularHolder(val binding: StorePopularItemListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setPopularData(storePopularData: StorePopularData) {
        Glide.with(itemView)
            .load(storePopularData.storePopularImage)
            .into(binding.storeIvPopular)
        binding.storeTvPopularBrand.text = storePopularData.storePopularBrandTitle
        binding.storeTvPopularTitle.text = storePopularData.storePopularGoodsTitle
        binding.storeTvPopularPercent.text = storePopularData.storePopularPercent
        binding.storeTvPopularPrice.text = storePopularData.storePopularPrice.toString()
        binding.storeTvPopularReviewScore.text = storePopularData.storePopularReviewScore
        binding.storeTvPopularReviewCount.text = storePopularData.storePopularReviewCount.toString()
    }
}