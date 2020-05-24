package com.devwilfred.kafkademo.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    val messages = mutableListOf<String>()

    @KafkaListener(topics = ["test"], groupId = "server-group")
    fun listen(message: String) {
        messages.add(message)
    }
}
