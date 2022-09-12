package ru.vood.redisdemo.queue

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Service

@Service
class MessagePublisherImpl(
    private var redisTemplate: RedisTemplate<String, Any>,

private var topic: ChannelTopic

) : MessagePublisher {

    override fun publish(message: String) {
        redisTemplate.convertAndSend(topic.topic, message)
    }
}