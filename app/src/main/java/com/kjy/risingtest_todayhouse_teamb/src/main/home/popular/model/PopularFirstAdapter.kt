package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.PopularFirstListBinding

class PopularFirstAdapter: RecyclerView.Adapter<PopularFirstHolder>(){

    var popularFirstList = ArrayList<PopularFirstData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFirstHolder {
        val binding = PopularFirstListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularFirstHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularFirstHolder, position: Int) {
        val firstData = popularFirstList[position]
        holder.setPopularFirst(firstData)

    }

    override fun getItemCount(): Int {
        return popularFirstList.size
    }
}

class PopularFirstHolder(val binding: PopularFirstListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setPopularFirst(popularFirstItem: PopularFirstData) {
        Glide.with(itemView)
            .load(popularFirstItem.uri)
            .into(binding.firstIv)
        binding.firstTvNormal.text = popularFirstItem.normalText
    }
}