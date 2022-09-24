package ru.vood.redisdemo.repository

interface RedisRepositoryCommon {
    /**
     * Return all movies
     */
    fun <T : Any> findAllMovies(table: String): Map<String, T>

    /**
     * Add key-value pair to Redis.
     */
    fun <T : Any> add(table: String, id: String, data: T)

    /**
     * Delete a key-value pair in Redis.
     */
    fun delete(table: String, id: String)

    /**
     * find a movie
     */
    fun <T : Any> findMovie(table: String, id: String): T
}