package ru.devtsukerov.filmsearchapp.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.devtsukerov.filmsearchapp.data.MainRepository
import ru.devtsukerov.filmsearchapp.data.db.DatabaseHelper
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}