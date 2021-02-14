package `in`.bk.kotlincodebase.presentation.di.core

import `in`.bk.kotlincodebase.data.api.TMDBService
import `in`.bk.kotlincodebase.data.repository.artist.datasource.ArtistRemoteDataSource
import `in`.bk.kotlincodebase.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieRemoteDataSource
import `in`.bk.kotlincodebase.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowRemoteDataSource
import `in`.bk.kotlincodebase.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val apiKey: String){
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}