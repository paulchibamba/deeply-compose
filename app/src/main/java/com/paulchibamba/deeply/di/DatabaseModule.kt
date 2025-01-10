package com.paulchibamba.deeply.di

import android.content.Context
import androidx.room.Room
import com.paulchibamba.deeply.data.local.DeeplyDatabase
import com.paulchibamba.deeply.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        DeeplyDatabase::class.java,
        DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun provideDailyJournalDao(database: DeeplyDatabase) = database.dailyJournalDao()

    @Singleton
    @Provides
    fun provideDeepWorkSessionDao(database: DeeplyDatabase) = database.deepWorkSessionDao()

    @Singleton
    @Provides
    fun provideGoalDao(database: DeeplyDatabase) = database.goalDao()

    @Singleton
    @Provides
    fun provideHabitDao(database: DeeplyDatabase) = database.habitDao()

    @Singleton
    @Provides
    fun provideProjectDao(database: DeeplyDatabase) = database.projectDao()

    @Singleton
    @Provides
    fun provideTaskDao(database: DeeplyDatabase) = database.taskDao()

    @Singleton
    @Provides
    fun provideUserDao(database: DeeplyDatabase) = database.userDao()

    @Singleton
    @Provides
    fun provideWeeklyReviewDao(database: DeeplyDatabase) = database.weeklyReviewDao()

}