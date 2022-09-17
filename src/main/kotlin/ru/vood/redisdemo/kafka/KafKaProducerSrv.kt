package ru.vood.redisdemo.kafka

interface KafKaProducerSrv<DTO> {
    val dtoToJsonConverter: DtoToJsonConverter<DTO>


    fun sendMessage(key: String, message: DTO)
}
