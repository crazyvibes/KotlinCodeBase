package `in`.bk.kotlincodebase.domain.usecase

import `in`.bk.kotlincodebase.data.model.artist.Artist
import `in`.bk.kotlincodebase.domain.repository.ArtistRepository

class GetArtistsUseCase (private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()

}