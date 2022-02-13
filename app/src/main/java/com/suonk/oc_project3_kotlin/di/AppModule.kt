package com.suonk.oc_project3_kotlin.di

import android.content.Context
import androidx.room.Room
import com.suonk.oc_project3_kotlin.models.AppDatabase
import com.suonk.oc_project3_kotlin.models.dao.NeighbourDao
import com.suonk.oc_project3_kotlin.repositories.DefaultRepository
import com.suonk.oc_project3_kotlin.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        )
            .allowMainThreadQueries()
            .addMigrations()
            .build()

    @Provides
    fun provideMovieDao(database: AppDatabase) = database.neighbourDao()

    @Provides
    fun provideRepository(dao: NeighbourDao) : DefaultRepository = MainRepository(dao)
}