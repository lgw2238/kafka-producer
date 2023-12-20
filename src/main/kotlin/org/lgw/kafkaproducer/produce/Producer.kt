package org.lgw.kafkaproducer.produce

import mu.KotlinLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class Producer (
    private val template: KafkaTemplate<String, String>
){
    fun send(topic: String, message : String){
        logger.info { ">> send message: [$topic]: $message" }
        template.send(topic, message)
    }
}