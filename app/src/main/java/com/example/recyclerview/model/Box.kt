package com.example.recyclerview.model

import java.util.*

class Box(
    val width: Double,
    val length: Double,
    val height: Double
) {

    val id: String = UUID.randomUUID().toString()

    val volume: Double = width * length * height

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this.javaClass != other?.javaClass) return false
        other as Box
        return this.width == other.width
                && this.length == other.length
                && this.height == other.height
    }

    override fun hashCode(): Int {
        val factor = 31
        var result = width.hashCode()
        result = result * factor + length.hashCode()
        result = result * factor + height.hashCode()
        return result
    }
}