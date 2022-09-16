package ru.vood.redisdemo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter
import org.springframework.data.redis.serializer.GenericToStringSerializer
import ru.vood.redisdemo.queue.MessagePublisher
import ru.vood.redisdemo.queue.MessagePublisherImpl
import ru.vood.redisdemo.queue.MessageSubscriber

@Configuration
@ComponentScan("ru.vood")
class RedisConfig {

    @Value("\${spring.redis.password}")
    lateinit var password: String
    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        val jedisConnectionFactory: JedisConnectionFactory = JedisConnectionFactory()
//        jedisConnectionFactory.setPassword("qwerty123")
        jedisConnectionFactory.setPassword(password)

        return jedisConnectionFactory
    }

    @Bean
    fun redisTemplate(
        jedisConnectionFactory: JedisConnectionFactory
    ): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(jedisConnectionFactory)
        template.valueSerializer = GenericToStringSerializer(Any::class.java)
        return template
    }

    @Bean
    fun messageListener(): MessageListenerAdapter {
        return MessageListenerAdapter(MessageSubscriber())
    }

    @Bean
    fun redisContainer(        jedisConnectionFactory: JedisConnectionFactory): RedisMessageListenerContainer {
        val container = RedisMessageListenerContainer()
        container.setConnectionFactory(jedisConnectionFactory)
        container.addMessageListener(messageListener(), topic())
        return container
    }

    @Bean
    fun redisPublisher(template: RedisTemplate<String, Any>): MessagePublisher {
        return MessagePublisherImpl(template, topic())
    }

    @Bean
    fun topic(): ChannelTopic {
        return ChannelTopic("pubsub:queue")
    }
}