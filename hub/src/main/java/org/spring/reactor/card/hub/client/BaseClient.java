package org.spring.reactor.card.hub.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;
import java.util.List;
public class BaseClient {
    private final WebClient webClient;
    private final RestTemplate client;
    private final String baseUrl;
    BaseClient(String baseUrl) {
        this.webClient = WebClient.create(baseUrl);
        this.client = new RestTemplate();
        this.baseUrl = baseUrl;
    }

    protected Mono<ClientResponse> getClient(String uri, Map<String, String> variables,
                                             Map<String, String> headers, MediaType mediaType) {

        return webClient.get()
                .uri(uriBuilder -> buildQuery(uriBuilder, uri, variables))
                .headers(cons -> cons.setAll(headers))
                .accept(mediaType)
                .exchange();
    }

    private URI buildQuery(UriBuilder uriBuilder, String uri, Map<String, String> variables) {
        uriBuilder.replacePath(uri);
        variables.forEach(uriBuilder::queryParam);
        return uriBuilder.build();
    }


    protected <T> ResponseEntity<List<T>> getClientBasic(String uri, Map<String, String> variables,
                                                    MultiValueMap<String, String> headers,
                                                    MediaType mediaType) {
        return client.exchange(baseUrl + uri, HttpMethod.GET, new HttpEntity(headers),
                new ParameterizedTypeReference<List<T>>() {
                }, variables);
    }
}
