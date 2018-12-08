package bdma.ulb.adb.kcclickspersistence.config
import io.vertx.core.Vertx
import io.vertx.kafka.client.consumer.KafkaConsumer
import io.vertx.kafka.client.producer.KafkaProducer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.ByteArraySerializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaConfig {

    @Autowired
    Vertx vertx

    @Bean("kafka")
    KafkaConsumer<String,byte[]> kafkaConsumer(){
        Properties config = new Properties()
        def host = "localhost:9092"
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host)
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class)
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class)
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "kc-clicks-persistor")
        return KafkaConsumer.create(vertx, config)
    }

}
