package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.recent

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StoreRecentItemListBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.BuyActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.ResultHomeMain
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.StoreHomeResponse
import java.text.DecimalFormat

class StoreRecentAdapter: RecyclerView.Adapter<StoreRecentHolder>() {

    var storeRecentList = ArrayList<ResultHomeMain>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreRecentHolder {
        val binding = StoreRecentItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreRecentHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreRecentHolder, position: Int) {
        val recentData = storeRecentList[position]
        holder.setRecentData(recentData)

    }

    override fun getItemCount(): Int {
        return storeRecentList.size
    }
}

class StoreRecentHolder(val binding: StoreRecentItemListBinding): RecyclerView.ViewHolder(binding.root) {

    // Context를 가져옴
    private val context = binding.root.context

    fun setRecentData(storeRecentData: ResultHomeMain) {
    Glide.with(itemView)
        .load("https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/165060369920429882.jpg?gif=1&w=1280&h=1280&c=c&webp=1")
        .into(binding.storeIvRecent)
    binding.storeTvRecentBrand.text = storeRecentData.storeTitle
    binding.storeTvRecentTitle.text = storeRecentData.goodsTitle
    val decFormat = DecimalFormat("#,###")
    val recentChangePrice = decFormat.format(storeRecentData.originPrice)
    binding.storeTvRecentPrice.text = recentChangePrice
    val percentSymbol = "%"
    binding.storeTvRecentPercent.text = storeRecentData.percentRate.toString().plus(percentSymbol)
    binding.storeTvRecentReviewCount.text = storeRecentData.reviewCount.toString()
    binding.storeTvRecentReviewScore.text = storeRecentData.reviewScore.toString()

        // 리사이클러뷰 아이템 클릭 다음 액티비티로 이동
        itemView.setOnClickListener {
            val intent = Intent(context, BuyActivity::class.java)
            intent.run {
                context.startActivity(intent)
            }
        }
    }
}