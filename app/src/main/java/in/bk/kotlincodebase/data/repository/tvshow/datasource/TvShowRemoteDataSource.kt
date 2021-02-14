package `in`.bk.kotlincodebase.data.repository.tvshow.datasource

import `in`.bk.kotlincodebase.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}