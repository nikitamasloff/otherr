package com.example.recyclerview.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffCallback<T>(
    private val oldList: List<T>,
    private val newList: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}