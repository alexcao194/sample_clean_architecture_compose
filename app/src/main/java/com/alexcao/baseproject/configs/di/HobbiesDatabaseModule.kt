package com.alexcao.baseproject.configs.di

import android.content.Context
import androidx.room.Room
import com.alexcao.baseproject.data.data_sources.database.HobbiesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HobbiesDatabaseModule {
    @Singleton
    @Provides
    fun provideHobbiesDatabase(
        @ApplicationContext context: Context
    ): HobbiesDatabase {
        return Room.databaseBuilder(context, HobbiesDatabase::class.java, HobbiesDatabase.HOBBIES_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideHobbiesDao(hobbiesDatabase: HobbiesDatabase) = hobbiesDatabase.hobbyDao()
}