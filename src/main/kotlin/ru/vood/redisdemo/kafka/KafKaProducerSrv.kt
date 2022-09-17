package ru.vood.redisdemo.kafka

interface KafKaProducerSrv<DTO> {


    fun sendMessage(key: String, message: DTO)
}
