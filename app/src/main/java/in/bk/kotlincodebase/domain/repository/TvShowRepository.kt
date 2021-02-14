package `in`.bk.kotlincodebase.domain.repository

import `in`.bk.kotlincodebase.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}