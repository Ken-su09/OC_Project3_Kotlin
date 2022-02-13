package com.suonk.oc_project3_kotlin.ui.fragments

import androidx.fragment.app.Fragment
import com.suonk.oc_project3_kotlin.ui.activities.MainActivity

abstract class BaseFragment : Fragment() {
    protected val navController by lazy {
        (activity as MainActivity).navController
    }

    protected val cxt by lazy {
        activity as MainActivity
    }
}