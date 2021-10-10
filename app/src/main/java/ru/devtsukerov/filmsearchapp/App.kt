package ru.devtsukerov.filmsearchapp

import android.app.Application
import ru.devtsukerov.filmsearchapp.di.AppComponent
import ru.devtsukerov.filmsearchapp.di.DaggerAppComponent


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}