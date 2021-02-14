package `in`.bk.kotlincodebase.data.repository.movie.datasource

import `in`.bk.kotlincodebase.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}