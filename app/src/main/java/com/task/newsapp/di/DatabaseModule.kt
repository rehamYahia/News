package com.task.newsapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.task.newsapp.database.db.ArticalDatabase
import com.task.newsapp.database.dao.ArticalsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    @Synchronized
    fun provideDbInstance(@ApplicationContext context: Context) : ArticalDatabase {
        return Room.databaseBuilder(context.applicationContext , ArticalDatabase::class.java , "ArticalDB")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDao(articalDatabase: ArticalDatabase): ArticalsDao {
        return articalDatabase.getArticalDao()
    }
}


