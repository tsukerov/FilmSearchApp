package ru.devtsukerov.filmsearchapp.utils

import ru.devtsukerov.filmsearchapp.data.entity.TmdbFilm
import ru.devtsukerov.filmsearchapp.domain.Film
import java.util.*

object Converter {
    fun convertApiListToDtoList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            ))
        }
        return result
    }
}