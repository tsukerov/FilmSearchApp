package ru.devtsukerov.filmsearchapp.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.devtsukerov.filmsearchapp.data.MainRepository
import ru.devtsukerov.filmsearchapp.data.TmdbApi
import ru.devtsukerov.filmsearchapp.data.preferences.PreferenceProvider
import ru.devtsukerov.filmsearchapp.domain.Interactor
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}