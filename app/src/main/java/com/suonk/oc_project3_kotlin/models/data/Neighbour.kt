package com.suonk.oc_project3_kotlin.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "neighbour")
data class Neighbour(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "avatarUrl")
    val avatarUrl: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "phoneNumber")
    val phoneNumber: String,
    @ColumnInfo(name = "aboutMe")
    val aboutMe: String,
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Int = 0,
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)