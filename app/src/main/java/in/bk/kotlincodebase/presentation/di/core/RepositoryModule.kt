package `in`.bk.kotlincodebase.presentation.di.core

import `in`.bk.kotlincodebase.data.repository.artist.ArtistRepositoryImpl
import `in`.bk.kotlincodebase.data.repository.artist.datasource.ArtistCacheDataSource
import `in`.bk.kotlincodebase.data.repository.artist.datasource.ArtistLocalDataSource
import `in`.bk.kotlincodebase.data.repository.artist.datasource.ArtistRemoteDataSource
import `in`.bk.kotlincodebase.data.repository.movie.MovieRepositoryImpl
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieCacheDataSource
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieLocalDataSource
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieRemoteDataSource
import `in`.bk.kotlincodebase.data.repository.tvshow.TvShowRepositoryImpl
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowCacheDataSource
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowLocalDataSource
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowRemoteDataSource
import `in`.bk.kotlincodebase.domain.repository.ArtistRepository
import `in`.bk.kotlincodebase.domain.repository.MovieRepository
import `in`.bk.kotlincodebase.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }
}