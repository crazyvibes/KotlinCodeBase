package `in`.bk.kotlincodebase.domain.usecase

import `in`.bk.kotlincodebase.data.model.artist.Artist
import `in`.bk.kotlincodebase.domain.repository.ArtistRepository

class UpdateArtistsUseCase (private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}