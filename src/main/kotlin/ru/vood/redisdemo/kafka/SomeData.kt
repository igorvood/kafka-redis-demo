package ru.vood.redisdemo.kafka

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.util.*

data class SomeData(
    val id: Long,
    val string: String = "SomeString",
    val boolean: Boolean = false,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mi:ss")
    val date: Date = Date(),
    val int: Int = 12,
    val bigDecimal: BigDecimal = BigDecimal(12),
)