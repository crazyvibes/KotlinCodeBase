package `in`.bk.kotlincodebase.presentation.movie

import `in`.bk.kotlincodebase.domain.usecase.GetMoviesUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateMoviesUsecase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase,updateMoviesUsecase) as T
    }
}