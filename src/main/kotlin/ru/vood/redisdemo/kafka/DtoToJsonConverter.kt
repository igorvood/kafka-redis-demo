package ru.vood.redisdemo.kafka

interface DtoToJsonConverter<T> {

    fun convertToJson(dto: T): String

    fun convertFromJson(jsonStr: String): T

}
