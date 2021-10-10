package ru.devtsukerov.filmsearchapp.di.modules

import dagger.Module
import dagger.Provides
import ru.devtsukerov.filmsearchapp.data.MainRepository
import ru.devtsukerov.filmsearchapp.data.TmdbApi
import ru.devtsukerov.filmsearchapp.domain.Interactor
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}