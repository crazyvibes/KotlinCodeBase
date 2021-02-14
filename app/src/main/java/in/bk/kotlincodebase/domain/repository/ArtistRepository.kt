package `in`.bk.kotlincodebase.domain.repository

import `in`.bk.kotlincodebase.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}