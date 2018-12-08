package bdma.ulb.adb.kcclickspersistence.config

import io.vertx.core.Vertx
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class VertxConfig {

    @Bean("vertx")
    Vertx vertx() {
        Vertx.vertx()
    }


}
