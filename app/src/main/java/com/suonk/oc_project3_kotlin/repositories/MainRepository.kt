package com.suonk.oc_project3_kotlin.repositories

import com.suonk.oc_project3_kotlin.models.dao.NeighbourDao
import com.suonk.oc_project3_kotlin.models.data.Neighbour
import javax.inject.Inject

class MainRepository @Inject constructor(private val neighbourDao: NeighbourDao) :
    DefaultRepository {

    override fun getAllNeighbours() = neighbourDao.getAllNeighbours()
    override fun getAllFavoritesNeighbours() = neighbourDao.getAllFavoritesNeighbours()

    override suspend fun insertNeighbour(neighbour: Neighbour) {
        neighbourDao.insertNeighbour(neighbour)
    }

    override suspend fun updateNeighbour(neighbour: Neighbour) {
        neighbourDao.updateNeighbour(neighbour)
    }

    override suspend fun deleteNeighbour(neighbour: Neighbour) {
        neighbourDao.deleteNeighbour(neighbour)
    }
}