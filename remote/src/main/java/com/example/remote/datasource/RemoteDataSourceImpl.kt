package com.example.remote.datasource

import com.example.remote.network.api.DeezerApi
import com.example.remote.network.dto.AlbumDto
import com.example.remote.network.dto.AlbumListDto
import com.example.remote.network.dto.ArtistDto
import com.example.remote.network.dto.ArtistListDto
import javax.inject.Inject

/**
 * Implementation of [RemoteDataSource].
 *
 */
class RemoteDataSourceImpl @Inject constructor(
    private val deezerApi: DeezerApi
) : RemoteDataSource {

    override suspend fun getArtists(query: String): ArtistListDto? {
        return try {
            val result = deezerApi.getArtists(query)
            if (result.isSuccessful)
                result.body()
            else
                null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getArtist(artistId: Int): ArtistDto? {
        return try {
            val result = deezerApi.getArtist(artistId)
            if (result.isSuccessful)
                result.body()
            else
                null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getArtistAlbums(artistId: Int): AlbumListDto? {
        return try {
            val result = deezerApi.getArtistAlbums(artistId)
            if (result.isSuccessful)
                result.body()
            else
                null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getAlbum(albumId: Int): AlbumDto? {
        return try {
            val result = deezerApi.getAlbum(albumId)
            if (result.isSuccessful)
                result.body()
            else
                null
        } catch (e: Exception) {
            null
        }
    }
}