package ru.devtsukerov.filmsearchapp

import android.app.Application
import ru.devtsukerov.filmsearchapp.di.AppComponent
import ru.devtsukerov.filmsearchapp.di.DaggerAppComponent
import ru.devtsukerov.filmsearchapp.di.modules.DatabaseModule
import ru.devtsukerov.filmsearchapp.di.modules.DomainModule
import ru.devtsukerov.filmsearchapp.di.modules.RemoteModule


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}