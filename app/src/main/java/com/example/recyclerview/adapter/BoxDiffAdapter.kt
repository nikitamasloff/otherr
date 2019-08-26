package com.example.recyclerview.adapter

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.R
import com.example.recyclerview.model.Box
import com.example.recyclerview.viewholder.BoxViewHolder
import com.example.recyclerview.viewholder.UnsafeViewHolder

class BoxDiffAdapter(items: List<Box>) : DiffAdapter<Box>(items) {

    constructor() : this(emptyList())

    override fun getDiffCallback(
        oldList: List<Box>,
        newList: List<Box>
    ): DiffUtil.Callback = BoxDiffCallback(oldList, newList)

    override fun getLayoutResId(position: Int): Int = R.layout.item_box

    override fun getViewHolder(layoutResId: Int, itemView: View): UnsafeViewHolder<Box> =
        BoxViewHolder(itemView)
}