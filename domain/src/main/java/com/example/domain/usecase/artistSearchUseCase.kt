package com.example.domain.usecase

import com.example.domain.repository.ArtistRepository
import javax.inject.Inject

/**
 * Use case for artist searching.
 */
class ArtistSearchUseCase @Inject constructor(
    private val artistRepository: ArtistRepository
) {

    /**
     * Retrieves the artist having [artistId] as identifier.
     */
    suspend fun getArtist(artistId : Int) =
        artistRepository.getArtist(artistId)

    /**
     * Retrieves all artists matching [query].
     */
    suspend fun getArtistsByQuery(query : String) =
        artistRepository.getArtists(query)
}