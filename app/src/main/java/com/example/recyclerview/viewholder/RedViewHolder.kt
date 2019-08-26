package com.example.recyclerview.viewholder

import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.recyclerview.R
import com.example.recyclerview.model.Color

class RedViewHolder(itemView: View) : UnsafeViewHolder<Color.RED>(itemView) {

    private val cardView: CardView = itemView.findViewById(R.id.card_view)

    override fun applyBinding(obj: Color.RED) {
        obj.proveThatIAmRed()
        proveThatIAmRedViewHolder()
        val color = findColorByid(obj.colorResId)
        cardView.setBackgroundColor(color)
    }

    fun proveThatIAmRedViewHolder() {
    }

    @ColorInt
    private fun findColorByid(@ColorRes colorResId: Int): Int =
        ContextCompat.getColor(itemView.context, colorResId)
}