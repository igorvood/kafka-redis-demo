package ru.vood.redisdemo.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import ru.vood.redisdemo.kafka.dto.JsonDto

interface KafKaProducerSrv {
    val logger: Logger
        get() = LoggerFactory.getLogger(this::class.java)

    val kafkaTemplate: KafkaTemplate<String, String>
    fun sendMessage(key: String, message: JsonDto)

//     private inline fun<reified DTO: JsonDto> sendMessage(topicName: String, key: String, message: DTO):Unit{
//                val convertToJson = message.toJson()
//        logger.info(String.format("Message sent -> %s", convertToJson))
//        this.kafkaTemplate.send(CA_TOPIC_NAME, key, convertToJson)
//
//    }
}
