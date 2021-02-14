package `in`.bk.kotlincodebase.data.repository.artist.datasource

import `in`.bk.kotlincodebase.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>

}