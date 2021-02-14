package `in`.bk.kotlincodebase.presentation.tv

import `in`.bk.kotlincodebase.domain.usecase.GetTvShowsUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateTvShowsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TvShowViewModelFactory (
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(
            getTvShowsUseCase,
            updateTvShowsUseCase
        ) as T
    }
}