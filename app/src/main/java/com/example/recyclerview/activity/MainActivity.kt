package com.example.recyclerview.activity

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.adapter.BoxDiffAdapter
import com.example.recyclerview.adapter.UnsafeColorAdapter
import com.example.recyclerview.model.Box
import com.example.recyclerview.model.Color

class MainActivity : AppCompatActivity() {

    private lateinit var uiHandler: Handler
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uiHandler = Handler()
        recyclerView = findViewById(R.id.recycler_view)
        configureRecyclerView()

        applyBoxDiffAdapter()
        //applyUnsafeColorAdapter()
    }

    private fun configureRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun applyBoxDiffAdapter() {
        val box1 = Box(0.4, 0.3, 0.2)
        val box2 = Box(30.0, 20.5, 29.3)
        val box3 = Box(30.0, 20.5, 29.3)
        val box4 = Box(60.0, 55.5, 29.6)
        val box5 = Box(99.0, 99.5, 99.3)
        val box6 = Box(45.3, 22.2, 33.3)
        val box7 = Box(45.3, 22.2, 33.3)

        var itemsList =
            listOf(box1, box2, box3, box4, box6, box5, box7)
        val anotherItemsList = MutableList(100) { index ->
            Box(width = index * 0.1, length = index * 0.2, height = 0.3 * index)
        }

        itemsList = itemsList + anotherItemsList
        itemsList = itemsList.shuffled()

        toast("Applying random list")

        recyclerView.adapter = BoxDiffAdapter(itemsList)
        postDelayed(10000) {
            val newItems1 = itemsList.sortedBy(Box::volume)
            (recyclerView.adapter as BoxDiffAdapter).updateItems(newItems1)
            toast("Applying sorted list")

            postDelayed(10000) {
                val newItems2 = itemsList.sortedByDescending(Box::volume)
                (recyclerView.adapter as BoxDiffAdapter).updateItems(newItems2)
                toast("Applying sorted descending list")
            }
        }
    }

    private fun applyUnsafeColorAdapter() {
        val itemsList = MutableList(100) { index ->
            when (index % 8) {
                0 -> Color.RED
                1 -> Color.GREEN
                2 -> Color.RED
                3 -> Color.RED
                4 -> Color.GREEN
                5 -> Color.RED
                6 -> Color.GREEN
                7 -> Color.GREEN
                else -> Color.RED
            }
        }
        recyclerView.adapter = UnsafeColorAdapter(itemsList)
    }

    private fun postDelayed(delayMillis: Long, action: () -> Unit) {
        uiHandler.postDelayed(action, delayMillis)
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
