package com.kjy.risingtest_todayhouse_teamb.src.main.store.model

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StoreCategoryListBinding

class StoreCategoryAdapter(var categoryList : ArrayList<CategoryData>): RecyclerView.Adapter<CategoryHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val binding = StoreCategoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val categoryData = categoryList[position]
        holder.setData(categoryData)
    }

    override fun getItemCount(): Int {
        Log.d("카테고리 리스트 사이즈", "${categoryList.size}")
        return categoryList.size
    }
}

// 뷰 홀더(데이터 클래스와 연결)
class CategoryHolder(val binding: StoreCategoryListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setData(categoryData: CategoryData) {
        Glide.with(itemView)
            .load(categoryData.uri)
            .into(binding.storeCategoryIv)
        binding.storeCategoryTitle.text = categoryData.categoryTitle
    }
}