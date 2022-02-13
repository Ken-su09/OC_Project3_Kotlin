package com.suonk.oc_project3_kotlin.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suonk.oc_project3_kotlin.databinding.ItemNeighbourBinding
import com.suonk.oc_project3_kotlin.models.data.Neighbour

class NeighbourListAdapter(private val onClickedCallback: (Int) -> Unit) :
    ListAdapter<Neighbour, NeighbourListAdapter.ViewHolder>(NeighbourComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemNeighbourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour = getItem(position)
        holder.onBind(neighbour)
    }

    inner class ViewHolder(private val binding: ItemNeighbourBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(neighbour: Neighbour) {

        }
    }

    class NeighbourComparator : DiffUtil.ItemCallback<Neighbour>() {
        override fun areItemsTheSame(oldItem: Neighbour, newItem: Neighbour) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Neighbour, newItem: Neighbour): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.aboutMe == newItem.aboutMe &&
                    oldItem.address == newItem.address &&
                    oldItem.avatarUrl == newItem.avatarUrl &&
                    oldItem.phoneNumber == newItem.phoneNumber &&
                    oldItem.isFavorite == newItem.isFavorite
        }

    }
}