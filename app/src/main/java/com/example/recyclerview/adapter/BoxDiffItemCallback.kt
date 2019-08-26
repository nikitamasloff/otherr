package com.example.recyclerview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.model.Box

class BoxDiffItemCallback : DiffUtil.ItemCallback<Box>() {

    override fun areItemsTheSame(oldItem: Box, newItem: Box): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Box, newItem: Box): Boolean =
        oldItem == newItem
}