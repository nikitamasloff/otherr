package com.example.appcomponents.log

import android.util.Log

fun <T : Any> T.log(text: String) {
    val name = this.javaClass.simpleName
    Log.d(name, "#$name: $text")
}