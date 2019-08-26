package com.example.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class UnsafeViewHolder<out T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var obj: T? = null

    fun onBind(obj: @UnsafeVariance T) {
        this.obj = obj
        this.applyBinding(obj)
    }

    abstract fun applyBinding(obj: @UnsafeVariance T)
}