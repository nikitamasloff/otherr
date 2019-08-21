package com.example.appcomponents.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appcomponents.R
import com.example.appcomponents.log.LogFragment
import kotlinx.android.synthetic.main.fragment_main.*

private const val INNER_COUNTER_KEY = "inner_counter"

private var globalCounter: Int = 1

private val alpha get() = if (globalCounter < 1) 255 else 255 / globalCounter

class MainFragment : LogFragment(printLifecycle = true) {

    companion object {
        fun increment() {
            globalCounter++
        }

        fun decrement() {
            globalCounter--
        }

        fun getIncrementalTag() = "${MainFragment::class.java.simpleName} #$globalCounter"
    }

    private var innerCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.run {
            innerCounter = getInt(INNER_COUNTER_KEY)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val color = Color.argb(alpha, 255, 0, 0)
        view.setBackgroundColor(color)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counter.apply {
            text = innerCounter.toString()
            setOnClickListener {
                text = (++innerCounter).toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(INNER_COUNTER_KEY, innerCounter)
    }
}