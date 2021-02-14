package `in`.bk.kotlincodebase.data.repository.tvshow.datasource

import `in`.bk.kotlincodebase.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}