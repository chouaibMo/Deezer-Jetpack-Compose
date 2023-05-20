package com.example.domain.model


/**
 * Data class defining the domain object of a Track.
 */
data class Track(
    /**
     * Track's identifier.
     */
    var id: Int,

    /**
     * Track's readability.
     */
    var readable: Boolean,

    /**
     * Track's title.
     */
    var title: String,

    /**
     * Track's link.
     */
    var link: String,

    /**
     * Track's duration is seconds.
     */
    var duration: Int,

    /**
     * Whether the track contains explicit lyrics.
     */
    var explicitLyrics : Boolean,

    /**
     * Track's preview url (30 seconds).
     */
    var preview: String,
)