package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.ReviewPhotoListBinding

class BuyReviewPhotoAdapter(var reviewPhotoList : ArrayList<BuyReviewPhotoData>): RecyclerView.Adapter<ReviewPhotoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewPhotoHolder {
        val binding = ReviewPhotoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewPhotoHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewPhotoHolder, position: Int) {
        val reviewPhotoData = reviewPhotoList[position]
        holder.setReviewPhoto(reviewPhotoData)
    }

    override fun getItemCount(): Int {
        return reviewPhotoList.size
    }
}

class ReviewPhotoHolder(val binding: ReviewPhotoListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setReviewPhoto(buyReviewPhotoData: BuyReviewPhotoData) {
        Glide.with(itemView)
            .load(buyReviewPhotoData.uri)
            .into(binding.buyIvReviewPhoto)
    }
}