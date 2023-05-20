package com.example.domain.repository

import com.example.domain.model.Album

/**
 * Album repository interface.
 */
interface AlbumRepository {

    /**
     * Retrieves the [Album] having [albumId] as identifier.
     */
    suspend fun getAlbum(albumId : Int) : Album?

    /**
     * Retrieves all the [Album] of the artist having [artistId] as identifier.
     */
    suspend fun getArtistAlbums(artistId : Int) : List<Album>
}