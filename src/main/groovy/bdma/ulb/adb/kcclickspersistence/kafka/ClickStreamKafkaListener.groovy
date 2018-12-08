package bdma.ulb.adb.kcclickspersistence.kafka

import bdma.ulb.adb.kcclickspersistence.domain.Click
import bdma.ulb.adb.kcclickspersistence.domain.KafkaTopics
import bdma.ulb.adb.kcclickspersistence.repository.ClickRepository
import bdma.ulb.adb.kcclickspersistence.util.Json
import groovy.util.logging.Slf4j
import io.vertx.kafka.client.consumer.KafkaConsumer
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
@Slf4j
class ClickStreamKafkaListener  {

    private final KafkaConsumer<String, byte[]> kafka
    private final ClickRepository clickRepository


    ClickStreamKafkaListener(
            KafkaConsumer<String, byte[]> kafkaConsumer,
            ClickRepository clickRepository
    )
    {
        this.kafka = kafkaConsumer
        this.clickRepository = clickRepository
    }

    @PostConstruct
    void streamClickEvents() {
        kafka.handler { record ->
            def offset = record.offset()
            def payload = record.value()
            def json = new String(payload)

            log.debug "OffSet {}", offset
            def click = Json.toObject(json, Click)

            clickRepository.save(click)
        }

        kafka.subscribe(KafkaTopics.CLICK)

    }

}
