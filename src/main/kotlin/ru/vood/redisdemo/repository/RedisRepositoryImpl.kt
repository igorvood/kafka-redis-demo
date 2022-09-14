package ru.vood.redisdemo.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import ru.vood.redisdemo.model.Movie
import javax.annotation.PostConstruct

@Repository
class RedisRepositoryImpl (private val redisTemplate: RedisTemplate<String, Any>) :
    RedisRepository {
    private lateinit var hashOperations: HashOperations<String, Any, Any>

    @PostConstruct
    private fun init() {
        hashOperations = redisTemplate.opsForHash()
    }

    override fun add(movie: Movie) {
        hashOperations.put(KEY, movie.id, movie.name)
    }

    override fun delete(id: String) {
        hashOperations.delete(KEY, id)
    }

    override fun findMovie(id: String): Movie {
        return hashOperations.get(KEY, id) as Movie
    }

    override fun findAllMovies(): Map<Any, Any> {
        return hashOperations.entries(KEY)
    }

    companion object {
        private const val KEY = "Movie"
    }
}