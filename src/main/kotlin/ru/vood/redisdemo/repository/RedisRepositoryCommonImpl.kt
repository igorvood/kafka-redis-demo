package ru.vood.redisdemo.repository

import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct

@Repository
class RedisRepositoryCommonImpl(
    private val redisTemplate: RedisTemplate<String, Any>
) : RedisRepositoryCommon {

    private lateinit var hashOperations: HashOperations<String, Any, Any>

    @PostConstruct
    private fun init() {
        hashOperations = redisTemplate.opsForHash()
    }

    override fun <T : Any> findAllMovies(table: String): Map<String, T> {
        val entries = hashOperations.entries(table)
            .map { it -> it.key as String to it.value as T }.toMap()
        return entries
    }

    override fun <T : Any> add(table: String, id: String, data: T) {
        hashOperations.put(table, id, data)
    }

    override fun delete(table: String, id: String) {
        hashOperations.delete(table, id)
    }

    override fun <T : Any> findMovie(table: String, id: String): T {
        return hashOperations.get(table, id) as T
    }
}