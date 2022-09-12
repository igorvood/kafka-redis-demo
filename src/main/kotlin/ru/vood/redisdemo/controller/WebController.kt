package ru.vood.redisdemo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import ru.vood.redisdemo.model.Movie
import ru.vood.redisdemo.repository.RedisRepository

@Controller
@RequestMapping("/")
class WebController(
    private val redisRepository: RedisRepository
    ) {
    @RequestMapping("/")
    fun index(): String {
        return "index"
    }

    @RequestMapping("/keys")
    @ResponseBody
    fun keys(): Map<Any, Any> {
        return redisRepository.findAllMovies()
    }

    @RequestMapping("/values")
    @ResponseBody
    fun findAll(): Map<String, String> {
        val aa = redisRepository.findAllMovies()
        val map: MutableMap<String, String> = HashMap()
        for ((key1) in aa) {
            val key = key1 as String
            map[key] = aa[key].toString()
        }
        return map
    }

    @RequestMapping(value = ["/add"], method = [RequestMethod.POST])
    fun add(
        @RequestParam key: String,
        @RequestParam value: String
    ): ResponseEntity<String> {
        val movie = Movie(key, value)
        redisRepository.add(movie)
        return ResponseEntity(HttpStatus.OK)
    }

    @RequestMapping(value = ["/delete"], method = [RequestMethod.POST])
    fun delete(@RequestParam key: String): ResponseEntity<String> {
        redisRepository.delete(key)
        return ResponseEntity(HttpStatus.OK)
    }
}