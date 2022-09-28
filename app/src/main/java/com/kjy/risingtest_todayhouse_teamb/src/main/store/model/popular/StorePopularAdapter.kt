package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.popular

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StorePopularItemListBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.BuyActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.ResultHomeMain
import java.text.DecimalFormat

class StorePopularAdapter: RecyclerView.Adapter<StorePopularHolder>() {

    var storePopularList = ArrayList<ResultHomeMain>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorePopularHolder {
        val binding = StorePopularItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorePopularHolder(binding)
    }

    override fun onBindViewHolder(holder: StorePopularHolder, position: Int) {
        val popularData = storePopularList[position]
        holder.setPopularData(popularData)
    }

    override fun getItemCount(): Int {
        return storePopularList.size
    }
}

class StorePopularHolder(val binding: StorePopularItemListBinding): RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    fun setPopularData(storePopularData: ResultHomeMain) {
        Glide.with(itemView)
            .load("https://image.ohou.se/i/bucketplace-v2-development/uploads/deals/166384823266276140.png?gif=1&w=1280&h=1280&c=c&webp=1")
            .into(binding.storeIvPopular)
        binding.storeTvPopularBrand.text = storePopularData.storeTitle
        binding.storeTvPopularTitle.text = storePopularData.goodsTitle
        val percentSymbol = "%"
        binding.storeTvPopularPercent.text = storePopularData.percentRate.toString().plus(percentSymbol)
        val decFormat = DecimalFormat("#,###")
        val popularChangePrice = decFormat.format(storePopularData.originPrice)
        binding.storeTvPopularPrice.text = popularChangePrice
        binding.storeTvPopularReviewScore.text = storePopularData.reviewScore.toString()
        binding.storeTvPopularReviewCount.text = storePopularData.reviewCount.toString()

        // 리사이클러뷰 아이템 클릭 다음 액티비티로 이동
        itemView.setOnClickListener {
            val intent = Intent(context, BuyActivity::class.java)
            intent.run {
                context.startActivity(intent)
            }
        }
    }
}