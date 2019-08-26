package com.example.recyclerview.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class DiffAdapter<T>(items: List<T>) :
    UnsafeAdapter<T>(items) {

    constructor() : this(emptyList())

    override fun updateItems(items: List<T>) {
        val diffCallback = getDiffCallback(this.items, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        this.items = items
    }

    protected abstract fun getDiffCallback(
        oldList: List<T>,
        newList: List<T>
    ): DiffUtil.Callback
}