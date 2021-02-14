package `in`.bk.kotlincodebase.presentation.di.core

import `in`.bk.kotlincodebase.data.db.ArtistDao
import `in`.bk.kotlincodebase.data.db.MovieDao
import `in`.bk.kotlincodebase.data.db.TMDBDataBase
import `in`.bk.kotlincodebase.data.db.TvShowDao
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDataBase {
        return Room.databaseBuilder(context,TMDBDataBase::class.java,"tmdbclient")
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDataBase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDataBase): TvShowDao {
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDataBase): ArtistDao {
        return tmdbDatabase.artistDao()
    }


}