package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.relative

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StoreRelativeItemListBinding
import java.text.DecimalFormat

class StoreRelativeAdapter: RecyclerView.Adapter<StoreRelativeHolder>() {

    var storeRelativeList = mutableListOf<StoreRelativeData>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreRelativeHolder {
        val binding = StoreRelativeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreRelativeHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreRelativeHolder, position: Int) {
        val relativeData = storeRelativeList[position]
        holder.setRelativeData(relativeData)
    }

    override fun getItemCount(): Int {
        return storeRelativeList.size
    }

}

class StoreRelativeHolder(val binding: StoreRelativeItemListBinding): RecyclerView.ViewHolder(binding.root) {

    val dec = DecimalFormat("#.###")

    fun setRelativeData(storeRelativeData : StoreRelativeData) {
        Glide.with(itemView)
            .load(storeRelativeData.storeRelativeImage)
            .into(binding.storeIvRelative)
        binding.storeTvRelativeBrand.text = storeRelativeData.storeRelativeBrandTitle
        binding.storeTvRelativeTitle.text = storeRelativeData.storeRelativeGoodsTitle
        binding.storeTvRelativePercent.text = storeRelativeData.storeRelativePercent
        binding.storeTvRelativePrice.text = dec.format(storeRelativeData.storeRelativePrice).toString()
        binding.storeTvRelativeReviewScore.text = storeRelativeData.storeRelativeReviewScore
        binding.storeTvRelativeReviewCount.text = dec.format(storeRelativeData.storeRelativeReviewCount).toString()
    }
}
