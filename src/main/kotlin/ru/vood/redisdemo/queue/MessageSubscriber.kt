package ru.vood.redisdemo.queue

import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Service

@Service
class MessageSubscriber : MessageListener {
    override fun onMessage(message: Message, pattern: ByteArray?) {
        messageList.add(message.toString())
        println("Message received: " + String(message.body))
    }

    companion object {
        var messageList: MutableList<String> = ArrayList()
    }
}