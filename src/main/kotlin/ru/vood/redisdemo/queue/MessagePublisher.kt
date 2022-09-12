package ru.vood.redisdemo.queue

interface MessagePublisher {
    fun publish(message: String)
}