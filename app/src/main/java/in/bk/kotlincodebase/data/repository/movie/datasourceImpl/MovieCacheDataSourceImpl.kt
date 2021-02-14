package `in`.bk.kotlincodebase.data.repository.movie.datasourceImpl

import `in`.bk.kotlincodebase.data.model.movie.Movie
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}