package com.buzin.ds.cinemafun

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.buzin.ds.cinemafun.databinding.FilmFragmentBinding

class FilmFragment : Fragment() {

    companion object {
        fun newInstance() = FilmFragment()
    }

    private lateinit var viewModel: FilmViewModel

    private var _bind: FilmFragmentBinding? = null
    private val binding get() = _bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = FilmFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        viewModel.getFilmData().observe(activity as LifecycleOwner, Observer { state ->
            render(state)
        })
        var film = arguments?.getParcelable<Film>("FILM_DATA")
        if(film != null) {
            fillFragment(film)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }

    private fun render(state: AppState) {
        if (state is AppState.Success) {
            val film = state.film as Film
            fillFragment(film)
        }
    }
    private fun fillFragment(film: Film)
    {
        binding.originalTitle.text = film.title
        binding.overview.text = film.overview
        binding.popularity.text = film.popularity.toString()
        //binding.productionCompanies = film.production_companies
        //binding.poster.text = film.poster
        binding.releaseDate.text = film.releaseDate
    }
}