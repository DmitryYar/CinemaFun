package com.buzin.ds.cinemafun

interface FilmsRepositoryInterface {
    fun getFilmFromServer(id: Int): Film

    fun getFilmFromDB(id: Int): Film
}