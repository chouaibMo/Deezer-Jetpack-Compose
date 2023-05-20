package com.example.domain.usecase

import com.example.domain.model.Album
import com.example.domain.repository.AlbumRepository
import javax.inject.Inject

/**
 * Use case for artist's album.
 */
class ArtistAlbumUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) {

    /**
     * Get all [Album] of the artist having [artistId] as identifier.
     */
    private suspend fun getArtistAlbums(artistId : Int) =
         albumRepository.getArtistAlbums(artistId)

    /**
     * Get the [Album] having [albumId] as identifier.
     */
    private suspend fun getAlbum(albumId : Int) =
        albumRepository.getAlbum(albumId)


    /**
     * Retrieves the first album of the artist having [artistId] as identifier.
     */
    suspend fun getArtistFirstAlbum(artistId: Int) : Album? {
        val albums = getArtistAlbums(artistId)
        return getAlbum(albums.first().id)
    }
}