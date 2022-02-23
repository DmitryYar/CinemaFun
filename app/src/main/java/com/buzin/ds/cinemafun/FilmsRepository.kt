package com.buzin.ds.cinemafun

class FilmsRepository: FilmsRepositoryInterface {
    override fun getFilmFromDB(id: Int): Film {
        return Film(
            "Спиздили",
            60.1,
            "2003-12-12",
            "img.jpg",
            "Все спиздили, перепиздили",
            listOf("Коламбиа", "Пикчерз")
        )
    }

    override fun getFilmFromServer(id: Int): Film {
        return Film(
            "Спиздили",
            60.1,
            "2003-12-12",
            "img.jpg",
            "Все спиздили, перепиздили",
            listOf("Коламбиа", "Пикчерз")
        )
    }
}