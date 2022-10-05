package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.PopularThirdListBinding

class PopularThirdAdapter: RecyclerView.Adapter<PopularThirdHolder>() {

    var popularThirdList = ArrayList<PopularThirdData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularThirdHolder {
        val binding = PopularThirdListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularThirdHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularThirdHolder, position: Int) {
        val thirdData = popularThirdList[position]
        holder.setPopularThird(thirdData)
    }

    override fun getItemCount(): Int {
        return popularThirdList.size
    }
}

class PopularThirdHolder(val binding: PopularThirdListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setPopularThird(popularThirdItem: PopularThirdData) {
        Glide.with(itemView)
            .load(popularThirdItem.uri)
            .into(binding.thirdIv)
        binding.thirdTv.text = popularThirdItem.thirdText
    }
}