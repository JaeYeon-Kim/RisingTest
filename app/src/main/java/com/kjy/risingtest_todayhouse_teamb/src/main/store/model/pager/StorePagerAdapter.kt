package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StorePagerListBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.ResultHomeAd

class StorePagerAdapter: RecyclerView.Adapter<StorePagerHolder>(){

    var storePagerList = ArrayList<ResultHomeAd>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorePagerHolder {
        val binding = StorePagerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorePagerHolder(binding)
    }

    override fun onBindViewHolder(holder: StorePagerHolder, position: Int) {
        val storePagerData = storePagerList[position]
        holder.setStorePager(storePagerData)
    }

    override fun getItemCount(): Int {
        return storePagerList.size
    }

}

class StorePagerHolder(val binding: StorePagerListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setStorePager(storePagerItem: ResultHomeAd) {
        Glide.with(itemView)
            .load(storePagerItem.adUrl)
            .into(binding.storeIvPager)
    }
}