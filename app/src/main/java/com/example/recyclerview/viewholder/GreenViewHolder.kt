package com.example.recyclerview.viewholder

import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.recyclerview.R
import com.example.recyclerview.model.Color

class GreenViewHolder(itemView: View) : UnsafeViewHolder<Color.GREEN>(itemView) {

    private val cardView: CardView = itemView.findViewById(R.id.card_view)

    override fun applyBinding(obj: Color.GREEN) {
        obj.proveThanIAmGreen()
        proveThatIAmGreenViewHolder()
        val color = findColorByid(obj.colorResId)
        cardView.setBackgroundColor(color)
    }

    fun proveThatIAmGreenViewHolder() {
    }

    @ColorInt
    private fun findColorByid(@ColorRes colorResId: Int): Int =
        ContextCompat.getColor(itemView.context, colorResId)
}