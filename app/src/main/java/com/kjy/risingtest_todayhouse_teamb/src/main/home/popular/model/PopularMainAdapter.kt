package com.kjy.risingtest_todayhouse_teamb.src.main.home.popular.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.PopularCategoryMainListBinding

class PopularMainAdapter(val categoryMainList: ArrayList<PopularMainData>): RecyclerView.Adapter<PopularMainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMainHolder {
        val binding = PopularCategoryMainListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularMainHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMainHolder, position: Int) {
        val categoryData = categoryMainList[position]
        holder.setCategoryMain(categoryData)
    }

    override fun getItemCount(): Int {
        return categoryMainList.size
    }
}


class PopularMainHolder(val binding: PopularCategoryMainListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setCategoryMain(popularMainData: PopularMainData) {
        Glide.with(itemView)
            .load(popularMainData.uri)
            .into(binding.popularCategoryMainIv)
        binding.popularCategoryMainTitle.text = popularMainData.categoryTitle
    }
}