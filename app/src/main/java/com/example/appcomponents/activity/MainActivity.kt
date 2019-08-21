package com.example.appcomponents.activity

import android.os.Bundle
import android.view.View
import com.example.appcomponents.R
import com.example.appcomponents.fragment.MainFragment
import com.example.appcomponents.log.LogActivity
import com.example.appcomponents.log.log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LogActivity(printLifecycle = true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            log("After recreation")
            printFragmentBackStack()
        }

        setListeners()
    }

    private enum class FragmentAction {
        ADD, REPLACE, REMOVE
    }

    private fun setListeners() {
        btn_add.setOnClickListener(getListener(FragmentAction.ADD))
        btn_remove.setOnClickListener(getListener(FragmentAction.REMOVE))
        btn_replace.setOnClickListener(getListener(FragmentAction.REPLACE))
        btn_pop.setOnClickListener {
            supportFragmentManager.popBackStack()
            MainFragment.decrement()
            printFragmentBackStack()
        }
    }

    private fun getListener(action: FragmentAction) =
        View.OnClickListener {
            val addToBackStack = cb_add_to_backstack.isChecked
            val allowReordering = cb_allow_reordering.isChecked
            supportFragmentManager
                .beginTransaction()
                .apply {
                    val layoutResId = R.id.fragment_container
                    val fragment = MainFragment()
                    when (action) {
                        FragmentAction.ADD -> add(layoutResId, fragment)
                        FragmentAction.REMOVE -> {
                            val foundedFragment =
                                supportFragmentManager.findFragmentById(layoutResId)
                                    ?: return@OnClickListener
                            remove(foundedFragment)
                        }
                        FragmentAction.REPLACE -> replace(layoutResId, fragment)
                    }
                }
                .apply { setReorderingAllowed(allowReordering) }
                .apply {
                    if (addToBackStack) {
                        val tag = MainFragment.getIncrementalTag()
                        addToBackStack(tag)
                    }
                }
                .commit()
                .also { MainFragment.increment() }
                .also { printFragmentBackStack() }
        }

    override fun onBackPressed() {
        MainFragment.decrement()
        printFragmentBackStack()
        super.onBackPressed()
    }
}
