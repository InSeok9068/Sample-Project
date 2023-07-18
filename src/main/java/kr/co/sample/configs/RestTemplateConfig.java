package kr.co.sample.configs;


import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    public static final int MAX_CONNECTION_TOTAL = 100;
    public static final int MAX_CONNECTION_PER_ROUTE = 10;

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        var connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_CONNECTION_TOTAL);
        connectionManager.setDefaultMaxPerRoute(MAX_CONNECTION_PER_ROUTE);
        connectionManager.setDefaultConnectionConfig(ConnectionConfig.custom()
                .setConnectTimeout(Timeout.ofSeconds(WebConfig.DEFAULT_CONNECTION_TIME_OUT))
                .setSocketTimeout(Timeout.ofSeconds(WebConfig.DEFAULT_READ_TIME_OUT))
                .build());

        return connectionManager;
    }

    @Bean
    public HttpClient httpClient(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {
        return HttpClientBuilder.create()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .build();
    }

    @Bean
    public RestTemplate restTemplate(HttpClient httpClient) {
        var requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);
    }

}
