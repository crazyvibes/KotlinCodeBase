package `in`.bk.kotlincodebase.data.db

import `in`.bk.kotlincodebase.data.model.artist.Artist
import `in`.bk.kotlincodebase.data.model.movie.Movie
import `in`.bk.kotlincodebase.data.model.tvshow.TvShow
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDataBase :RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}