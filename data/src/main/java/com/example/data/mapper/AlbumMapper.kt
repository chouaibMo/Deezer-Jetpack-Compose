package com.example.data.mapper

import com.example.domain.model.Album
import com.example.domain.model.Track
import com.example.remote.network.dto.AlbumDto
import com.example.remote.network.dto.TrackDto


/**
 * Extension of [AlbumDto].
 * Maps an [AlbumDto] to an [Album].
 *
 */
fun AlbumDto.toAlbum(): Album =
    Album(
        id = id,
        title = title,
        link = link,
        cover = cover,
        coverMedium = coverMedium,
        releaseDate = releaseDate,
        label = label,
        fans = fans,
        available = available,
        explicitLyrics = explicitLyrics,
        tracks = tracks?.data?.map { it.toTrack() }

    )

/**
 * Extension of [TrackDto].
 * Maps an [TrackDto] to a [Track].
 *
 */
fun TrackDto.toTrack(): Track =
    Track(
        id = id,
        readable = readable,
        title = title,
        link = link,
        duration = duration,
        explicitLyrics = explicit,
        preview = preview,
        )