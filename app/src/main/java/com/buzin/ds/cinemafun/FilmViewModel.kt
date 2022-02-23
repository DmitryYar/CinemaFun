package com.buzin.ds.cinemafun

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception
import kotlin.random.Random

class FilmViewModel : ViewModel() {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo = FilmsRepository()
    fun getFilmData(): LiveData<AppState> = liveDataToObserve
    fun getFilm() {
        liveDataToObserve.value = AppState.Loading

        Thread {
            Thread.sleep(2000)

            if (Random.nextBoolean()) {
                liveDataToObserve.postValue(AppState.Success(repo.getFilmFromServer(1)))
            } else {
                liveDataToObserve.postValue(AppState.Error(Exception("Ошибка соединения")))
            }
        }.start()
    }
}