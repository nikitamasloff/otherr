package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.viewholder.UnsafeViewHolder

abstract class UnsafeAdapter<T>(protected var items: List<T>) :
    RecyclerView.Adapter<UnsafeViewHolder<T>>() {

    constructor() : this(emptyList())

    open fun updateItems(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnsafeViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType, parent, false)
        return getViewHolder(viewType, view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UnsafeViewHolder<T>, position: Int) {
        val item = items[position]
        holder.onBind(item)
    }

    override fun getItemViewType(position: Int): Int = getLayoutResId(position)

    @LayoutRes
    protected abstract fun getLayoutResId(position: Int): Int

    protected abstract fun getViewHolder(
        @LayoutRes layoutResId: Int,
        itemView: View
    ): UnsafeViewHolder<T>
}