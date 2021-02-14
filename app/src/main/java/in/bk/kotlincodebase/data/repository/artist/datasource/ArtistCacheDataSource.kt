package `in`.bk.kotlincodebase.data.repository.artist.datasource

import `in`.bk.kotlincodebase.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}