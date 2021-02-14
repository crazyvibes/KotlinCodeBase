package `in`.bk.kotlincodebase.presentation.tv

import `in`.bk.kotlincodebase.domain.usecase.GetTvShowsUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateTvShowsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {
    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}