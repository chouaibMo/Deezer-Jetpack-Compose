package com.example.domain.model

/**
 * Data class defining the domain object of an Artist.
 */
data class Artist(
    /**
     * Artist's identifier.
     */
    var id: Int,

    /**
     * Artist's name.
     */
    var name: String,

    /**
     * Artist's link.
     */
    var link : String,

    /**
     * Artist's picture.
     */
    var picture: String,

    /**
     * Artist's medium picture.
     */
    var pictureMedium: String,

    /**
     * Artist's albums number.
     */
    var nbAlbum: Int,

    /**
     * Artist's fans number.
     */
    var nbFan: Int,

)
