package `in`.bk.kotlincodebase.data.repository.tvshow.datasourceImpl

import `in`.bk.kotlincodebase.data.api.TMDBService
import `in`.bk.kotlincodebase.data.model.tvshow.TvShowList
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource{
    override suspend fun getTvShows()
            : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}