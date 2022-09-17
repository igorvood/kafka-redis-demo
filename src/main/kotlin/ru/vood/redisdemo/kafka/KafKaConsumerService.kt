package ru.vood.redisdemo.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.stereotype.Service
import ru.vood.redisdemo.kafka.AppConstants.CA_TOPIC_NAME
import java.lang.String

//@Service
class KafKaConsumerService {

    private val logger: Logger = LoggerFactory.getLogger(KafKaProducerService::class.java)

    @KafkaListener(topics = [CA_TOPIC_NAME]        , groupId = AppConstants.GROUP_ID
    )
    fun consume(user: SomeData) {


        logger.info(String.format("User created -> %s", user))
    }
}