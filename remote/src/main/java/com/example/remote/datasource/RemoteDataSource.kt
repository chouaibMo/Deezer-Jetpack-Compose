package com.example.remote.datasource

import com.example.remote.network.dto.AlbumDto
import com.example.remote.network.dto.AlbumListDto
import com.example.remote.network.dto.ArtistDto
import com.example.remote.network.dto.ArtistListDto

/**
 * Remote datasource interface.
 */
interface RemoteDataSource {

    /**
     * Retrieves all artists matching the [query], null otherwise.
     */
    suspend fun getArtists(query: String): ArtistListDto?

    /**
     * Retrieves artist having [artistId] as identifier, null otherwise..
     */
    suspend fun getArtist(artistId: Int): ArtistDto?

    /**
     * Retrieves all albums of the artist having [artistId] as identifier, null otherwise.
     */
    suspend fun getArtistAlbums(artistId: Int): AlbumListDto?

    /**
     * Retrieves the album having [albumId] as identifier, null otherwise.
     */
    suspend fun getAlbum(albumId: Int): AlbumDto?


}