package com.example.deezertest.util

/**
 * Formatting a duration in second to the format mm:ss.
 */
fun Int.durationDisplay(): String =
    "${(this / 60).toString().padStart(2, '0')}:${
        (this % 60).toString().padStart(2, '0')
    }"

fun String?.releaseYearDisplay() : String =
    this?.substringBefore("-") ?: "N/A"