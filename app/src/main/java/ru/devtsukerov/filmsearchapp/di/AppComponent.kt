package ru.devtsukerov.filmsearchapp.di

import dagger.Component
import ru.devtsukerov.filmsearchapp.di.modules.DatabaseModule
import ru.devtsukerov.filmsearchapp.di.modules.DomainModule
import ru.devtsukerov.filmsearchapp.di.modules.RemoteModule
import ru.devtsukerov.filmsearchapp.viewmodel.HomeFragmentViewModel
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}