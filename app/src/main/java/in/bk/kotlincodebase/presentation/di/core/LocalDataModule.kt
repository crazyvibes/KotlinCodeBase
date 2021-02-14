package `in`.bk.kotlincodebase.presentation.di.core

import `in`.bk.kotlincodebase.data.db.ArtistDao
import `in`.bk.kotlincodebase.data.db.MovieDao
import `in`.bk.kotlincodebase.data.db.TvShowDao
import `in`.bk.kotlincodebase.data.repository.artist.datasource.ArtistLocalDataSource
import `in`.bk.kotlincodebase.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieLocalDataSource
import `in`.bk.kotlincodebase.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowLocalDataSource
import `in`.bk.kotlincodebase.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}