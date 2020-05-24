package com.devwilfred.kafkademo.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Service
class KafkaProducer @Autowired constructor(
        val kafkaTemplate: KafkaTemplate<String, String>,
        @Value("\${app-config.kafka.topic}")
        val topic: String
) {

    fun produce(message: String): ListenableFuture<SendResult<String, String>> {
        return kafkaTemplate.send(topic, message)
    }
}
