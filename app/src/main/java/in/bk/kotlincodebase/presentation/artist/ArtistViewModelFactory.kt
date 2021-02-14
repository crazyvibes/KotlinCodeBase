package `in`.bk.kotlincodebase.presentation.artist

import `in`.bk.kotlincodebase.domain.usecase.GetArtistsUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateArtistsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ArtistViewModelFactory (
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(
            getArtistsUseCase,
            updateArtistsUseCase
        ) as T
    }
}