package com.suonk.oc_project3_kotlin.ui.fragments.main_pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suonk.oc_project3_kotlin.databinding.FragmentNeighbourListBinding
import com.suonk.oc_project3_kotlin.ui.adapters.NeighbourListAdapter
import com.suonk.oc_project3_kotlin.ui.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val MODE_FAVORITE = "MODE_FAVORITE"

@AndroidEntryPoint
class NeighbourListFragment : BaseFragment() {

    companion object {
        fun newInstance(isFavoriteMode: Boolean) =
            NeighbourListFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(MODE_FAVORITE, isFavoriteMode)
                }
            }
    }

    private var isFavorite = false
    private var binding: FragmentNeighbourListBinding? = null
    private lateinit var neighbourListAdapter: NeighbourListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isFavorite = it.getBoolean(MODE_FAVORITE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNeighbourListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        neighbourListAdapter = NeighbourListAdapter({ id ->
//            val navDir =
        })
        getNeighboursListFromViewModel()
    }

    private fun getNeighboursListFromViewModel() {
        binding?.listNeighbours
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}