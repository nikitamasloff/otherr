package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerview.R
import com.example.recyclerview.model.Box
import com.example.recyclerview.viewholder.BoxViewHolder

class BoxListAdapter : ListAdapter<Box, BoxViewHolder>(BoxDiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_box, parent, false)
        return BoxViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoxViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }
}