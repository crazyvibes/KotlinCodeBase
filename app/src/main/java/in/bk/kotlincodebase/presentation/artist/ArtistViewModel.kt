package `in`.bk.kotlincodebase.presentation.artist

import `in`.bk.kotlincodebase.domain.usecase.GetArtistsUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateArtistsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}