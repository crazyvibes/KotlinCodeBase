package `in`.bk.kotlincodebase.presentation.movie

import `in`.bk.kotlincodebase.R
import `in`.bk.kotlincodebase.presentation.di.Injector
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)
        movieViewModel= ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)
    }
}