package com.example.domain.model

/**
 * Data class defining the domain object of an Album.
 */
data class Album(
    /**
     * Album's identifier.
     */
    var id: Int,

    /**
     * Album's title.
     */
    var title: String,

    /**
     * Album's link.
     */
    var link: String,

    /**
     * Album's cover url.
     */
    var cover: String,

    /**
     * Album's medium cover url.
     */
    var coverMedium: String,

    /**
     * Album's release date.
     */
    var releaseDate: String,

    /**
     * Album's fan number.
     */
    var fans: Int,

    /**
     * Album's label.
     */
    var label: String?,

    /**
     * Album's availability.
     */
    var available: Boolean,

    /**
     * Album's explicit lyrics presence.
     */
    var explicitLyrics: Boolean,

    /**
     * Album's tracks as a list of [Track].
     */
    var tracks: List<Track>?

)