package com.kjy.risingtest_todayhouse_teamb.src.main.store.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StoreCategoryGoodsListBinding

class GoodsCategoryAdapter : RecyclerView.Adapter<GoodsHolder>() {

    var goodsList = mutableListOf<GoodsCategoryData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {

        val binding = StoreCategoryGoodsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GoodsHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        val goodsData = goodsList[position]
        holder.setGoods(goodsData)

    }

    override fun getItemCount(): Int {
        return goodsList.size

    }
}

class GoodsHolder(val binding: StoreCategoryGoodsListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setGoods(goodsCategoryData: GoodsCategoryData) {
        Glide.with(itemView)
            .load(goodsCategoryData.uri)
            .into(binding.storeIvCategoryGoods)
    }
}