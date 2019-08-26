package com.example.recyclerview.model

import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import com.example.recyclerview.R

sealed class Color(
    @ColorRes val colorResId: Int,
    @LayoutRes val layoutResId: Int
) {
    object RED : Color(android.R.color.holo_red_light, R.layout.item_red) {

        fun proveThatIAmRed() {
        }
    }
    object GREEN : Color(android.R.color.holo_green_light, R.layout.item_green) {

        fun proveThanIAmGreen() {
        }
    }
}