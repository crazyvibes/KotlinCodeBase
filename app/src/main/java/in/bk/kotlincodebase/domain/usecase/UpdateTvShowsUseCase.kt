package `in`.bk.kotlincodebase.domain.usecase

import `in`.bk.kotlincodebase.data.model.tvshow.TvShow
import `in`.bk.kotlincodebase.domain.repository.TvShowRepository

class UpdateTvShowsUseCase (private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}