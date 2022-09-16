package ru.vood.redisdemo.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.serializer.JsonSerializer
import org.springframework.stereotype.Service
import ru.vood.redisdemo.kafka.AppConstants.CA_TOPIC_NAME
import ru.vood.redisdemo.runners.SomeData

@Service
class KafKaProducerService(
     val kafkaTemplate: KafkaTemplate<String, Any>
) {

    private val logger: Logger = LoggerFactory.getLogger(KafKaProducerService::class.java)

    fun sendMessage(key: String, message: SomeData) {
        logger.info(String.format("Message sent -> %s", message))
        this.kafkaTemplate.send(CA_TOPIC_NAME, key, message)
    }
}