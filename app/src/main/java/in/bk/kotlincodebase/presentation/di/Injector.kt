package `in`.bk.kotlincodebase.presentation.di

import `in`.bk.kotlincodebase.presentation.di.artist.ArtistSubComponent
import `in`.bk.kotlincodebase.presentation.di.movie.MovieSubComponent
import `in`.bk.kotlincodebase.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}