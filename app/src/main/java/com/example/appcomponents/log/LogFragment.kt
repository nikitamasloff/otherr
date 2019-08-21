package com.example.appcomponents.log

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class LogFragment(val printLifecycle: Boolean) : Fragment() {

    @CallSuper
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (printLifecycle) log("ON_ATTACH")
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (printLifecycle) log("ON_CREATE")
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (printLifecycle) log("ON_CREATE_VIEW")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (printLifecycle) log("ON_VIEW_CREATED")
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (printLifecycle) log("ON_ACTIVITY_CREATED")
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
    override fun onDestroyView() {
        super.onDestroyView()
        if (printLifecycle) log("ON_DESTROY_VIEW")
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        if (printLifecycle) log("ON_DESTROY")
    }

    @CallSuper
    override fun onDetach() {
        super.onDetach()
        if (printLifecycle) log("ON_DETACH")
    }
}