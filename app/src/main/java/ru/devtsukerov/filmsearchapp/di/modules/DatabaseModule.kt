package ru.devtsukerov.filmsearchapp.di.modules

import dagger.Module
import dagger.Provides
import ru.devtsukerov.filmsearchapp.data.MainRepository
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}