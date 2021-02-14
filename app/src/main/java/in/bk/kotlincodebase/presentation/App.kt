package `in`.bk.kotlincodebase.presentation

import `in`.bk.kotlincodebase.BuildConfig
import `in`.bk.kotlincodebase.presentation.di.Injector
import `in`.bk.kotlincodebase.presentation.di.artist.ArtistSubComponent
import `in`.bk.kotlincodebase.presentation.di.core.*
import `in`.bk.kotlincodebase.presentation.di.movie.MovieSubComponent
import `in`.bk.kotlincodebase.presentation.di.tvshow.TvShowSubComponent
import android.app.Application

class App:Application(),Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}