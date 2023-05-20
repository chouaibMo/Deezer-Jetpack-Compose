package com.example.data.mapper

import com.example.domain.model.Artist
import com.example.remote.network.dto.ArtistDto
import com.example.remote.network.dto.ArtistListDto


/**
 * Extension of [ArtistListDto].
 * Maps an [ArtistListDto] to a list of [Artist]
 *
 */
fun ArtistListDto.toArtistList(): List<Artist> =
    this.data.map {
        Artist(
            id = it.id,
            name = it.name,
            link = it.link,
            picture = it.picture,
            pictureMedium = it.pictureMedium,
            nbFan = it.nbFan,
            nbAlbum = it.nbAlbum,
        )
    }

/**
 * Extension of [ArtistDto].
 * Maps an [ArtistDto] to an [Artist]
 *
 */
fun ArtistDto.toArtist(): Artist =
    Artist(
        id = id,
        name = name,
        link = link,
        picture = picture,
        pictureMedium = pictureMedium,
        nbAlbum = nbAlbum,
        nbFan = nbFan
    )
