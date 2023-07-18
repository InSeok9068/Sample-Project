package kr.co.sample.configs;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    WebClient webClient() {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()
                        .responseTimeout(Duration.ofSeconds(WebConfig.DEFAULT_READ_TIME_OUT))
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, WebConfig.DEFAULT_CONNECTION_TIME_OUT * 1000)
                        .doOnConnected(conn -> conn
                                .addHandlerFirst(new ReadTimeoutHandler(WebConfig.DEFAULT_READ_TIME_OUT))
                                .addHandlerFirst(new WriteTimeoutHandler(WebConfig.DEFAULT_READ_TIME_OUT)))))
                .build();
    }
}
