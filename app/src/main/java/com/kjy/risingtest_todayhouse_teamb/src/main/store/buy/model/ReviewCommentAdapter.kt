package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.risingtest_todayhouse_teamb.databinding.ReviewCommentListBinding
import java.text.SimpleDateFormat

class ReviewCommentAdapter: RecyclerView.Adapter<ReviewCommentHolder>() {

    var reviewCommentList = ArrayList<ResultReview>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewCommentHolder {
        val binding = ReviewCommentListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewCommentHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewCommentHolder, position: Int) {
        val setReviewData = reviewCommentList[position]
        holder.setReviewComment(setReviewData)
    }

    override fun getItemCount(): Int {
        return reviewCommentList.size
    }

}

class ReviewCommentHolder(val binding: ReviewCommentListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setReviewComment(commentData: ResultReview) {
        binding.commentTvNickname.text = commentData.nickname
        binding.commentRb.rating = commentData.starRating.toFloat()
        binding.commentDate.text = commentData.reviewDate
        binding.commentBuyOption.text = commentData.buyOption
        Glide.with(itemView)
            .load("https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/snapshots/166342094411543349.jpeg?gif=1&w=320&h=320&c=c&webp=1")
            .into(binding.commentIvGoods)
        binding.commentTvWriting.text = commentData.writing
    }
}