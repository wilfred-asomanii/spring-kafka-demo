package com.devwilfred.kafkademo.config

/**
 * kafka config can also be done in code apart from
 * application properties files
 */
/*
@Configuration
class KafkaConfig(
        @Value("\${spring.kafka.bootstrap-servers}")
        val bootstrapServer: String
) {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val conf = mapOf(Pair(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer))
        return KafkaAdmin(conf)
    }

    */
/**
     * this bean is used by spring-kafka internally to create returned
     * topic on start up
     * @return @link
     *//*

    @Bean
    fun topic(): NewTopic {
        return NewTopic("topic", 1, 1.toShort())
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }

    fun producerFactory(): ProducerFactory<String, String> {
        val conf = mapOf(
                Pair(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer),
                Pair(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java),
                Pair(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        )
        return DefaultKafkaProducerFactory(conf)
    }
}
*/
