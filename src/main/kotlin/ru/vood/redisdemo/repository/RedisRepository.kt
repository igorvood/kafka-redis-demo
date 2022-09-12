package ru.vood.redisdemo.repository

import ru.vood.redisdemo.model.Movie

interface RedisRepository {
    /**
     * Return all movies
     */
    fun findAllMovies(): Map<Any, Any>

    /**
     * Add key-value pair to Redis.
     */
    fun add(movie: Movie)

    /**
     * Delete a key-value pair in Redis.
     */
    fun delete(id: String)

    /**
     * find a movie
     */
    fun findMovie(id: String): Movie
}