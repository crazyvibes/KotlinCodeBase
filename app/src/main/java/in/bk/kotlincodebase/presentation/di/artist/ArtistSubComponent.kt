package `in`.bk.kotlincodebase.presentation.di.artist

import `in`.bk.kotlincodebase.presentation.artist.ArtistActivity
import dagger.Subcomponent
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}