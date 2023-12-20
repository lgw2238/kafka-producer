package org.lgw.kafkaproducer

import org.lgw.kafkaproducer.produce.Producer
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class KafkaProducerApplication(private val producer: Producer,): ApplicationRunner {
    override fun run(args: ApplicationArguments?){
        repeat(10) { i ->
            producer.send("test", "테스트입니당 $i")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<KafkaProducerApplication>(*args)
}
