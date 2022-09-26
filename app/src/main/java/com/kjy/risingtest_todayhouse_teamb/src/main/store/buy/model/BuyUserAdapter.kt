package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.BuyUserListBinding

class BuyUserAdapter: RecyclerView.Adapter<BuyUserHolder>() {

    var buyUserList = mutableListOf<BuyUserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyUserHolder {
        val binding = BuyUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyUserHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyUserHolder, position: Int) {
        val userData = buyUserList[position]
        holder.setBuyUser(userData)
    }

    override fun getItemCount(): Int {
        return buyUserList.size
    }
}

class BuyUserHolder(val binding: BuyUserListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setBuyUser(buyUserData: BuyUserData) {
        Glide.with(itemView)
            .load(buyUserData.uri)
            .into(binding.buyUserStylingImage)

    }
}