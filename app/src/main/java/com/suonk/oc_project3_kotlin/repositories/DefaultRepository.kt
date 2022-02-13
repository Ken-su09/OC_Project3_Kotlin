package com.suonk.oc_project3_kotlin.repositories

import com.suonk.oc_project3_kotlin.models.data.Neighbour
import kotlinx.coroutines.flow.Flow

interface DefaultRepository {

    fun getAllNeighbours(): Flow<List<Neighbour>>
    fun getAllFavoritesNeighbours(): Flow<List<Neighbour>>
    suspend fun insertNeighbour(neighbour: Neighbour)
    suspend fun updateNeighbour(neighbour: Neighbour)
    suspend fun deleteNeighbour(neighbour: Neighbour)
}