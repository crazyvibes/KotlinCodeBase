package `in`.bk.kotlincodebase.data.repository.movie.datasource

import `in`.bk.kotlincodebase.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}