package `in`.bk.kotlincodebase.presentation.di.core

import `in`.bk.kotlincodebase.data.repository.artist.datasource.ArtistCacheDataSource
import `in`.bk.kotlincodebase.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import `in`.bk.kotlincodebase.data.repository.movie.datasource.MovieCacheDataSource
import `in`.bk.kotlincodebase.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowCacheDataSource
import `in`.bk.kotlincodebase.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}