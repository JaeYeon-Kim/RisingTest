package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StorePagerListBinding

class StorePagerAdapter: RecyclerView.Adapter<StorePagerHolder>(){

    var storePagerList = mutableListOf<StorePagerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorePagerHolder {
        val binding = StorePagerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorePagerHolder(binding)
    }

    override fun onBindViewHolder(holder: StorePagerHolder, position: Int) {
        val pagerData = storePagerList[position]
        holder.setPager(pagerData)
    }

    override fun getItemCount(): Int {
        return storePagerList.size
    }
}

class StorePagerHolder(val binding: StorePagerListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setPager(storePagerData: StorePagerData) {
        Glide.with(itemView)
            .load(storePagerData.uri)
            .into(binding.storeIvPager)
    }
}