package com.devwilfred.kafkademo.controllers

import com.devwilfred.kafkademo.service.KafkaConsumer
import com.devwilfred.kafkademo.service.KafkaProducer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.support.SendResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kafka")
class KafkaController @Autowired constructor(
        val kafkaConsumer: KafkaConsumer,
        val kafkaProducer: KafkaProducer
) {

    val logger: Logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/{message}")
    fun send(@PathVariable message: String) {
        kafkaProducer.produce(message)
                .addCallback(
                        { sendResult: SendResult<String, String>? ->
                            println(sendResult)
                            logger.info("Message Produced")
                        },
                        {
                            logger.error("Producer Error", it)
                        }
                )
    }

    @GetMapping
    fun receive(): List<String> {
        return kafkaConsumer.messages
    }
}
