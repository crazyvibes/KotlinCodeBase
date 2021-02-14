package `in`.bk.kotlincodebase.presentation.di.core

import `in`.bk.kotlincodebase.presentation.di.artist.ArtistSubComponent
import `in`.bk.kotlincodebase.presentation.di.movie.MovieSubComponent
import `in`.bk.kotlincodebase.presentation.di.tvshow.TvShowSubComponent
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}