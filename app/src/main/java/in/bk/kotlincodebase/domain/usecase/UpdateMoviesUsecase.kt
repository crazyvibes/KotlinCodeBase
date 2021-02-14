package `in`.bk.kotlincodebase.domain.usecase

import `in`.bk.kotlincodebase.data.model.movie.Movie
import `in`.bk.kotlincodebase.domain.repository.MovieRepository

class UpdateMoviesUsecase (private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}