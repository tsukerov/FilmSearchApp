package ru.devtsukerov.filmsearchapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.devtsukerov.filmsearchapp.App
import ru.devtsukerov.filmsearchapp.domain.*
import org.koin.core.KoinComponent
import org.koin.core.inject


class HomeFragmentViewModel : ViewModel(), KoinComponent {
    val filmsListLiveData = MutableLiveData<List<Film>>()


    private val interactor: Interactor by inject()

    init {
        interactor.getFilmsFromApi(1, object : ApiCallback {
            override fun onSuccess(films: List<Film>) {
                filmsListLiveData.postValue(films)
            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(films: List<Film>)
        fun onFailure()
    }
}