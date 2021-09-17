package ru.devtsukerov.filmsearchapp.domain

import ru.devtsukerov.filmsearchapp.data.MainRepository
import ru.devtsukerov.filmsearchapp.data.TmdbApi
import ru.devtsukerov.filmsearchapp.data.entity.*
import ru.devtsukerov.filmsearchapp.viewmodel.HomeFragmentViewModel
import ru.devtsukerov.filmsearchapp.utils.Converter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.devtsukerov.filmsearchapp.data.ApiConstants

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(ApiConstants.API_KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(call: Call<TmdbResultsDto>, response: Response<TmdbResultsDto>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.results))
            }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }
}