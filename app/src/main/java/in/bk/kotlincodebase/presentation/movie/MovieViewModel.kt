package `in`.bk.kotlincodebase.presentation.movie

import `in`.bk.kotlincodebase.domain.usecase.GetMoviesUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateMoviesUsecase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
): ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }
}