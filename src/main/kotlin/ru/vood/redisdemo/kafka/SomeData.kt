package ru.vood.redisdemo.kafka

import java.math.BigDecimal
import java.util.Date

data class SomeData(
    val id: Long,
    val string: String = "SomeString",
    val boolean: Boolean = false,
    val date: Date = Date(),
    val int: Int = 12,
    val bigDecimal: BigDecimal = BigDecimal(12),
)
