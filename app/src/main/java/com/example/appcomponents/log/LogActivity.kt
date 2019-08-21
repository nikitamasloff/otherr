package com.example.appcomponents.log

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity

abstract class LogActivity(val printLifecycle: Boolean) : AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (printLifecycle) log("ON_CREATE")
    }

    @CallSuper
    override fun onRestart() {
        super.onRestart()
        if (printLifecycle) log("ON_RESTART")
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        if (printLifecycle) log("ON_START")
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        if (printLifecycle) log("ON_RESUME")
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        if (printLifecycle) log("ON_PAUSE")
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        if (printLifecycle) log("ON_STOP")
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        if (printLifecycle) log("ON_DESTROY")
    }

    fun printFragmentBackStack() {
        val activityName = this.javaClass.simpleName
        log("FRAGMENTS BACKSTACK #$activityName")

        val fragmentManager = supportFragmentManager
        val count = fragmentManager.backStackEntryCount
        for (index in 0 until count) {
            val entry = fragmentManager.getBackStackEntryAt(index)
            val name = entry.name
            val id = entry.id
            log("[$index] - $name {id=$id}")
        }
    }
}