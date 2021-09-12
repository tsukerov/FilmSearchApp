package ru.devtsukerov.filmsearchapp.domain

import ru.devtsukerov.filmsearchapp.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}