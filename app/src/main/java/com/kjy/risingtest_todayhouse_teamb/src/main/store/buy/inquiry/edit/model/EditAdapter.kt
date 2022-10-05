package com.kjy.risingtest_todayhouse_teamb.src.main.store.buy.inquiry.edit.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kjy.risingtest_todayhouse_teamb.databinding.EditTypeListBinding

class EditAdapter: RecyclerView.Adapter<EditHolder>() {

    var editTypeList = ArrayList<EditData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditHolder {
        val binding = EditTypeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EditHolder(binding)
    }

    override fun onBindViewHolder(holder: EditHolder, position: Int) {
        val editTypeData = editTypeList[position]
        holder.setEditType(editTypeData)
    }

    override fun getItemCount(): Int {
        return editTypeList.size
    }
}

class EditHolder(val binding: EditTypeListBinding):RecyclerView.ViewHolder(binding.root) {
    fun setEditType(editTypeItem: EditData) {
        binding.editBtn.text = editTypeItem.type
    }

}