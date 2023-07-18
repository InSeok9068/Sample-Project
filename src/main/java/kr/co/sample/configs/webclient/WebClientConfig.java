package kr.co.sample.configs.webclient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import kr.co.sample.configs.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Slf4j
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
                .filter(ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
                    log.info("WebClient Filter Strat : {}", clientRequest.url());
                    return Mono.just(clientRequest);
                }))
                .filter(ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
                    log.info("WebClient Filter End");
                    return Mono.just(clientResponse);
                }))
                .build();
    }
}
