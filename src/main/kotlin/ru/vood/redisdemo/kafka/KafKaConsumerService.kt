package ru.vood.redisdemo.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import ru.vood.redisdemo.kafka.AppConstants.CA_TOPIC_NAME
import ru.vood.redisdemo.kafka.dto.Converter.fromJson
import ru.vood.redisdemo.kafka.dto.SomeData
import java.lang.String

@Service
class KafKaConsumerService(

) : KafKaConsumerSrv<SomeData> {

    private val logger: Logger = LoggerFactory.getLogger(KafKaProducerService::class.java)

    @KafkaListener(
        topics = [CA_TOPIC_NAME]
        , groupId = AppConstants.GROUP_ID
    )
    fun consume(user: kotlin.String) {
        val convertFromJson = user.fromJson<SomeData>()
//        logger.info(String.format("User created -> %s", convertFromJson))
    }
}