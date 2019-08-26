package com.example.recyclerview.adapter

import android.view.View
import com.example.recyclerview.model.Color
import com.example.recyclerview.viewholder.GreenViewHolder
import com.example.recyclerview.viewholder.RedViewHolder
import com.example.recyclerview.viewholder.UnsafeViewHolder

class UnsafeColorAdapter(items: List<Color>) : UnsafeAdapter<Color>(items) {

    constructor() : this(emptyList())

    override fun getLayoutResId(position: Int): Int = items[position].layoutResId

    override fun getViewHolder(layoutResId: Int, itemView: View): UnsafeViewHolder<Color> =
        when (layoutResId) {
            Color.RED.layoutResId -> RedViewHolder(itemView)
            Color.GREEN.layoutResId -> GreenViewHolder(itemView)
            else -> throw IllegalStateException("Invalid layoutResId")
        }
}