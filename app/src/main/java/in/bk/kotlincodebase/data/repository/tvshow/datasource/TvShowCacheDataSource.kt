package `in`.bk.kotlincodebase.data.repository.tvshow.datasource

import `in`.bk.kotlincodebase.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}