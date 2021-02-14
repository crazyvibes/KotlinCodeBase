package `in`.bk.kotlincodebase.domain.repository

import `in`.bk.kotlincodebase.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}