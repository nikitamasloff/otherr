package com.example.recyclerview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.model.Box

class BoxDiffCallback(
    private val oldList: List<Box>,
    private val newList: List<Box>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}