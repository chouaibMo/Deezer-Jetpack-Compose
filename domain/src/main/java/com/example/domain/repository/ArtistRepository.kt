package com.example.domain.repository

import com.example.domain.model.Artist

/**
 * Artist repository interface.
 */
interface ArtistRepository {

    /**
     * Retrieves all [Artist] matching the [query].
     */
    suspend fun getArtists(query : String) : List<Artist>

    /**
     * Retrieves the [Artist] having [id] as identifier.
     */
    suspend fun getArtist(id : Int) : Artist?
}