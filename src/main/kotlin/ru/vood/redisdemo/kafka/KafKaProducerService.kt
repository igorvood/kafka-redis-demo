package ru.vood.redisdemo.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.vood.redisdemo.kafka.AppConstants.CA_TOPIC_NAME

@Service
class KafKaProducerService(
     val kafkaTemplate: KafkaTemplate<String, String>,
     override val dtoToJsonConverter: DtoToJsonConverter<SomeData>
): KafKaProducerSrv<SomeData> {

    private val logger: Logger = LoggerFactory.getLogger(KafKaProducerService::class.java)

    override fun sendMessage(key: String, message: SomeData) {
        val convertToJson = dtoToJsonConverter.convertToJson(message)
        logger.info(String.format("Message sent -> %s", convertToJson))
        this.kafkaTemplate.send(CA_TOPIC_NAME, key, convertToJson)
    }

}