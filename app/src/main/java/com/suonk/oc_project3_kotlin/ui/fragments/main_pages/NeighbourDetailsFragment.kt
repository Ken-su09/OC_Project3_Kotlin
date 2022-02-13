package com.suonk.oc_project3_kotlin.ui.fragments.main_pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.suonk.oc_project3_kotlin.R
import com.suonk.oc_project3_kotlin.databinding.FragmentNeighbourDetailsBinding
import com.suonk.oc_project3_kotlin.models.data.Neighbour
import com.suonk.oc_project3_kotlin.ui.fragments.BaseFragment
import com.suonk.oc_project3_kotlin.viewmodels.NeighbourViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NeighbourDetailsFragment : BaseFragment() {

    private var isFavorite = false
    private lateinit var currentNeighbour: Neighbour
    private var binding: FragmentNeighbourDetailsBinding? = null
    private val viewModel: NeighbourViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNeighbourDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        getNeighbourFromViewModel()
        favoriteFabListener()
    }

    private fun getNeighbourFromViewModel() {
        viewModel.mutableLiveDataNeighbour.observe(viewLifecycleOwner) { neighbour ->
            if (neighbour != null) {
                currentNeighbour = neighbour
            }
            binding?.apply {
                Glide.with(cxt)
                    .load(neighbour?.avatarUrl)
                    .centerCrop()
                    .into(phoneIcon)

                neighbourName.text = neighbour?.name
                neighbourName1.text = neighbour?.name
                locationContent.text = neighbour?.name
                phoneContent.text = neighbour?.name
                socialNetworkContent.text = neighbour?.name
                neighbourDescriptionContent.text = neighbour?.name
                checkIfFavorite(neighbour?.isFavorite == 1)
                isFavorite = neighbour?.isFavorite == 1
            }
        }
    }

    private fun updateNeighbour() {
        viewModel.updateNeighbour(currentNeighbour)
    }

    private fun updateFavoriteFabIcon(res: Int) {
        binding?.apply {
            addToFavorites.setImageDrawable(AppCompatResources.getDrawable(cxt, res))
        }
    }

    private fun checkIfFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            updateFavoriteFabIcon(R.drawable.ic_star_white)
            currentNeighbour.isFavorite = 1
        } else {
            updateFavoriteFabIcon(R.drawable.ic_star_border_white)
            currentNeighbour.isFavorite = 0
        }
    }

    private fun favoriteFabListener() {
        binding?.addToFavorites?.setOnClickListener {
            isFavorite = !isFavorite
            checkIfFavorite(isFavorite)
        }
    }

    private fun initToolbar() {
        binding?.apply {
            cxt.setSupportActionBar(detailsToolbar)
            detailsToolbar.setBackgroundColor(ContextCompat.getColor(cxt, R.color.transparent))
            cxt.actionBar?.apply {
                setDisplayShowTitleEnabled(false)
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            updateNeighbour()
            cxt.supportFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}