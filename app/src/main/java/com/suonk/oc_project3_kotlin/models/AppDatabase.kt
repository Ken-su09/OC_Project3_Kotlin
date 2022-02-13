package com.suonk.oc_project3_kotlin.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.suonk.oc_project3_kotlin.models.dao.NeighbourDao
import com.suonk.oc_project3_kotlin.models.data.Neighbour

@Database(entities = [Neighbour::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun neighbourDao(): NeighbourDao
}