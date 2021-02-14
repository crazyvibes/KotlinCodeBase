package `in`.bk.kotlincodebase.data.repository.artist.datasource

import `in`.bk.kotlincodebase.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}