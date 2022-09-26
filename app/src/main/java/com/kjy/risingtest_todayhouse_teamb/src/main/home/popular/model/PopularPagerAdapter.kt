package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.HomePopularPagerListBinding

class PopularPagerAdapter(val popularPagerList : ArrayList<PopularPagerData>): RecyclerView.Adapter<PopularPagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularPagerHolder {
        val binding = HomePopularPagerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularPagerHolder, position: Int) {
        val pagerData = popularPagerList[position % 5]
        holder.setPopularPager(pagerData)
    }

    // 아이템 개수를 Int 값의 최대로 늘려준다.
    override fun getItemCount(): Int = Int.MAX_VALUE
}

class PopularPagerHolder(val binding: HomePopularPagerListBinding): RecyclerView.ViewHolder(binding.root){
    fun setPopularPager(popularPagerData : PopularPagerData) {
        Glide.with(itemView)
            .load(popularPagerData.uri)
            .into(binding.homePopularIvPager)
    }
}