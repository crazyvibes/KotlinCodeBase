package `in`.bk.kotlincodebase.data.repository.movie.datasourceImpl

import `in`.bk.kotlincodebase.data.api.TMDBService
import `in`.bk.kotlincodebase.data.model.movie.MovieList
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey:String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}