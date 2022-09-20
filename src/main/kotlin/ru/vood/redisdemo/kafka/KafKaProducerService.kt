package ru.vood.redisdemo.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.vood.redisdemo.kafka.AppConstants.CA_TOPIC_NAME
import ru.vood.redisdemo.kafka.dto.Converter.toJson
import ru.vood.redisdemo.kafka.dto.JsonDto

@Service
class KafKaProducerService(
    override val kafkaTemplate: KafkaTemplate<String, String>,
//     override val dtoToJsonConverter: DtoToJsonConverter<SomeData>
) : KafKaProducerSrv {

    override fun sendMessage(key: String, message: JsonDto) {
        val convertToJson = message.toJson()
//        logger.info(String.format("Message sent -> %s", convertToJson))
        this.kafkaTemplate.send(CA_TOPIC_NAME, key, convertToJson)

    }

}