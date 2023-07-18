package kr.co.sample.services;

import kr.co.sample.dtos.common.ResultGenericDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiRequestService {

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    @Value("${dumy.api-host}")
    private String dumyApiHost;

    public ResultGenericDto<Map<String, Object>> getUserByRestTemplate(int id) {
        URI uri = UriComponentsBuilder.fromHttpUrl(dumyApiHost + "/api/users")
                .path("{id}")
                .buildAndExpand(id)
                .toUri();

        ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<Map<String, Object>>() {
        });

        return ResultGenericDto.ofSuccess(Objects.requireNonNull(responseEntity).getBody());
    }

    public ResultGenericDto<Map<String, Object>> getUserByWebClient(int id) {
        URI uri = UriComponentsBuilder.fromHttpUrl(dumyApiHost + "/api/users")
                .path("{id}")
                .buildAndExpand(id)
                .toUri();

        ResponseEntity<Map<String, Object>> responseEntity = webClient.get()
                .uri(uri)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<Map<String, Object>>() {
                })
                .block();

        return ResultGenericDto.ofSuccess(Objects.requireNonNull(responseEntity).getBody());
    }
}
