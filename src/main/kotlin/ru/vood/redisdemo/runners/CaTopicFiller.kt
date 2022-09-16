package ru.vood.redisdemo.runners

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.redisdemo.kafka.KafKaProducerService

@Service
class CaTopicFiller(
    val kafKaProducerService: KafKaProducerService): CommandLineRunner  {
    override fun run(vararg args: String?) {

        IntRange(1,1000)
            .map { n -> SomeData(n) }

            .forEach { d-> kafKaProducerService.sendMessage(d.id.toString(), d) }


    }
}