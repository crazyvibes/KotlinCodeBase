package `in`.bk.kotlincodebase.data.repository.artist.datasourceImpl

import `in`.bk.kotlincodebase.data.api.TMDBService
import `in`.bk.kotlincodebase.data.model.artist.ArtistList
import `in`.bk.kotlincodebase.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDataSource{
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}