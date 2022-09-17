package ru.vood.redisdemo.runners

import org.springframework.boot.CommandLineRunner
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.vood.redisdemo.kafka.KafKaProducerService
import ru.vood.redisdemo.kafka.dto.SomeData
import java.util.Date

@Service
class CaTopicFiller(
    val kafKaProducerService: KafKaProducerService): CommandLineRunner  {
    override fun run(vararg args: String?) {

//        IntRange(1,1000)
//            .map { n -> SomeData(n) }
//
//            .forEach { d-> kafKaProducerService.sendMessage(d.id.toString(), d) }


    }
    @Scheduled(fixedDelay = 1000)
    fun pereodicalSend(){
        val d = SomeData(Date().time)

        kafKaProducerService.sendMessage(d.id.toString(), d)
    }
}