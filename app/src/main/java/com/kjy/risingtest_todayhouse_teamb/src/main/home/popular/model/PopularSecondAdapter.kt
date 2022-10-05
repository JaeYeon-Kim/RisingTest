package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.PopularSecondListBinding

class PopularSecondAdapter: RecyclerView.Adapter<PopularSecondHolder>() {

    var popularSecondList = ArrayList<PopularSecondData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularSecondHolder {
        val binding = PopularSecondListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularSecondHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularSecondHolder, position: Int) {
        val secondData = popularSecondList[position]
        holder.setPopularSecond(secondData)
    }

    override fun getItemCount(): Int {
        return popularSecondList.size
    }
}

class PopularSecondHolder(val binding: PopularSecondListBinding): RecyclerView.ViewHolder(binding.root){
    fun setPopularSecond(popularSecondItem: PopularSecondData) {
        Glide.with(itemView)
            .load(popularSecondItem.uri)
            .into(binding.secondIv)
        binding.secondTv.text = popularSecondItem.secondText
    }
}