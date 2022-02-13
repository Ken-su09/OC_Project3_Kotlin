package com.suonk.oc_project3_kotlin.models.dao

import androidx.room.*
import com.suonk.oc_project3_kotlin.models.data.Neighbour
import kotlinx.coroutines.flow.Flow

@Dao
interface NeighbourDao {

    /**
     *  getAllNeighbour() = neighbour1, neighbour2, neighbour3....
     */
    @Query("SELECT * FROM neighbour ORDER BY name ASC")
    fun getAllNeighbours(): Flow<List<Neighbour>>

    /**
     *  getAllFavoritesNeighbours() = neighbour1, neighbour2, neighbour3....
     */
    @Query("SELECT * FROM neighbour WHERE isFavorite == 1 ORDER BY name ASC")
    fun getAllFavoritesNeighbours(): Flow<List<Neighbour>>

    /**
     *  insertNeighbour(neighbour)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNeighbour(neighbour: Neighbour)

    /**
     *  updateNeighbour(neighbour)
     */
    @Update
    suspend fun updateNeighbour(neighbour: Neighbour)

    /**
     *  deleteNeighbour(neighbour)
     */
    @Delete
    suspend fun deleteNeighbour(neighbour: Neighbour)
}