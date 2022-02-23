package com.buzin.ds.cinemafun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.buzin.ds.cinemafun.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FilmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(FilmViewModel::class.java)

        viewModel.getFilmData().observe(this, Observer { state -> render(state) })
        viewModel.getFilm()

    }

    private fun render(state: AppState) {
        when (state) {
            is AppState.Success -> {
                val bundle = Bundle()
                bundle.putParcelable("FILM_DATA", state.film as Film)
                val filmFragment = FilmFragment()
                filmFragment.arguments = bundle
                showFragment(filmFragment)
            }
            is AppState.Error -> {
                Snackbar.make(binding.root, state.error.toString(), Snackbar.LENGTH_LONG)
                    .setAction("Попробовать снова") { viewModel.getFilm() }
                    .show()
            }
            is AppState.Loading -> {
                showFragment(LoadingFragment())
            }
        }
    }

    private fun showFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager
            .replace(R.id.fragment_frame_main, fragment)
            .addToBackStack("")
            .commit()
    }

}