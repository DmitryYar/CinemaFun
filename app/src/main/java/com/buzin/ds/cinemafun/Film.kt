package com.buzin.ds.cinemafun

import android.icu.text.CaseMap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val title: String,
    val popularity: Double,
    val releaseDate: String,
    val poster: String,
    val overview: String,
    val production_companies: List<String>
): Parcelable