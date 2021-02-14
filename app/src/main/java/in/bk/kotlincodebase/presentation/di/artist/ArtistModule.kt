package `in`.bk.kotlincodebase.presentation.di.artist

import `in`.bk.kotlincodebase.domain.usecase.GetArtistsUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateArtistsUseCase
import `in`.bk.kotlincodebase.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}