package com.task.newsapp.di

import android.app.Application
import androidx.room.Room
import com.task.newsapp.database.db.ArticalDatabase
import com.task.newsapp.database.dao.ArticalsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    @Synchronized
    fun provideDbInstance(application: Application) : ArticalDatabase {
        return Room.databaseBuilder(application , ArticalDatabase::class.java , "ArticalDB")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(articalDatabase: ArticalDatabase): ArticalsDao {
        return articalDatabase.getArticalDao()
    }
}