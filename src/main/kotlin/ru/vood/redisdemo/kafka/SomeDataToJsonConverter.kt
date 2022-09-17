package ru.vood.redisdemo.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service


@Service
class SomeDataToJsonConverter(
    val mapper: ObjectMapper
) : DtoToJsonConverter<SomeData> {

    override fun convertToJson(dto: SomeData): String {
        return mapper.writeValueAsString(dto)
    }

    override fun convertFromJson(jsonStr: String): SomeData {
        return mapper.readValue(jsonStr, SomeData::class.java)

    }
}