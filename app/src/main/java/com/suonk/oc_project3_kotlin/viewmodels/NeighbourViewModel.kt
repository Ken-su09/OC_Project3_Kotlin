package com.suonk.oc_project3_kotlin.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.suonk.oc_project3_kotlin.models.data.Neighbour
import com.suonk.oc_project3_kotlin.repositories.DefaultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NeighbourViewModel @Inject constructor(private val repo: DefaultRepository) : ViewModel() {

    val allNeighbours = repo.getAllNeighbours().asLiveData()
    val allFavoritesNeighbours = repo.getAllFavoritesNeighbours().asLiveData()

    fun insertNeighbour(neighbour: Neighbour) = viewModelScope.launch {
        repo.insertNeighbour(neighbour)
    }

    fun updateNeighbour(neighbour: Neighbour) = viewModelScope.launch {
        repo.insertNeighbour(neighbour)
    }

    fun deleteNeighbour(neighbour: Neighbour) = viewModelScope.launch {
        repo.insertNeighbour(neighbour)
    }

    var mutableLiveDataNeighbour = MutableLiveData<Neighbour?>()
    fun setMutableLiveDataNeighbour(neighbour: Neighbour?) {
        mutableLiveDataNeighbour.postValue(neighbour)
    }
}