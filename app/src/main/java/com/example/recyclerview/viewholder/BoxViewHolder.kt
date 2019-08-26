package com.example.recyclerview.viewholder

import android.view.View
import android.widget.TextView
import com.example.recyclerview.R
import com.example.recyclerview.model.Box

class BoxViewHolder(itemView: View) : UnsafeViewHolder<Box>(itemView) {

    private val idTextView: TextView = itemView.findViewById(R.id.id)
    private val volumeTextView: TextView = itemView.findViewById(R.id.volume)

    override fun applyBinding(obj: Box) {
        idTextView.text = "id = ${obj.id}"
        volumeTextView.text = "volume = ${obj.volume}"
    }
}