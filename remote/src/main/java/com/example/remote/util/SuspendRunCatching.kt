package com.example.remote.util

import kotlin.coroutines.cancellation.CancellationException

/**
 * Attempts [block], returning a [Result.success] if it succeeds, otherwise a [Result.failure] taking care not to break structured concurrency.
 */
internal suspend fun <T> suspendRunCatching(block: suspend () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (cancellationException: CancellationException) {
        throw cancellationException
    } catch (
        @Suppress("TooGenericExceptionCaught")
        exception: Exception
    ) {
        Result.failure(exception)
    }