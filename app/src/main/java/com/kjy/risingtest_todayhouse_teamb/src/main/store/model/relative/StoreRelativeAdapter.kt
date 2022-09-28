package com.kjy.risingtest_todayhouse_teamb.src.main.store.model.relative

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.StoreRelativeItemListBinding
import com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.BuyActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.store.model.ResultHomeMain
import java.text.DecimalFormat

class StoreRelativeAdapter: RecyclerView.Adapter<StoreRelativeHolder>() {

    var storeRelativeList = ArrayList<ResultHomeMain>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreRelativeHolder {
        val binding = StoreRelativeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreRelativeHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreRelativeHolder, position: Int) {
        val relativeData = storeRelativeList[position]
        holder.setRelativeData(relativeData)
    }

    override fun getItemCount(): Int {
        return storeRelativeList.size
    }

}

class StoreRelativeHolder(val binding: StoreRelativeItemListBinding): RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context


    fun setRelativeData(storeRelativeData: ResultHomeMain) {
        Glide.with(itemView)
            .load("https://image.ohou.se/i/bucketplace-v2-development/uploads/productions/162546803477431867.jpg?gif=1&w=1280&h=1280&c=c&webp=1")
            .into(binding.storeIvRelative)
        binding.storeTvRelativeBrand.text = storeRelativeData.storeTitle
        binding.storeTvRelativeTitle.text = storeRelativeData.goodsTitle
        val percentSymbol = "%"
        binding.storeTvRelativePercent.text = storeRelativeData.percentRate.toString().plus(percentSymbol)
        val decFormat = DecimalFormat("#,###")
        val relativeChangePrice = decFormat.format(storeRelativeData.originPrice)
        binding.storeTvRelativePrice.text = relativeChangePrice
        binding.storeTvRelativeReviewScore.text = storeRelativeData.reviewScore.toString()
        binding.storeTvRelativeReviewCount.text = storeRelativeData.reviewCount.toString()

        // 리사이클러뷰 아이템 클릭 다음 액티비티로 이동
        itemView.setOnClickListener {
            val intent = Intent(context, BuyActivity::class.java)
            intent.run {
                context.startActivity(intent)
            }
        }
    }
}
