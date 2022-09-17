package ru.vood.redisdemo.kafka.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.util.*

data class SomeData(
    val id: Long,
    val string: String = "SomeString",
    val boolean: Boolean = false,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    val date: Date = Date(),
    val int: Int = 12,
    val bigDecimal: BigDecimal = BigDecimal(12),
): DTO
