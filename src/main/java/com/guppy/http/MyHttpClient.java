package com.guppy.http;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guppy.http.entity.HTTPRequestType;
import com.guppy.http.entity.Request;

import reactor.core.publisher.Mono;

@Service
public class MyHttpClient {

	private static final Logger logger = LoggerFactory.getLogger(MyHttpClient.class);

	private final WebClient webClient;

	public MyHttpClient(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
		this.webClient = webClientBuilder.build();
	}

	public <T> Mono<T> makeEndpointCall(Request request, Class<T> responseType) {
		if (request.getRequestType() == HTTPRequestType.GET) {
			return makeAGetRequest(request, responseType);
		}
		if (request.getRequestType() == HTTPRequestType.POST) {
			return makeAPostRequest(request, responseType);
		}
		return null;
	}

	private <T> Mono<T> makeAPostRequest(Request request, Class<T> responseType) {
		return webClient.post().uri(makeURI(request)).body(BodyInserters.fromValue(request.getRequestBody())).retrieve()
				.bodyToMono(responseType);
	}

	/**
	 * read: https://reflectoring.io/spring-webclient/
	 */
	private <T> Mono<T> makeAGetRequest(Request request, Class<T> responseType) {
		return webClient.get().uri(makeURI(request)).retrieve().bodyToMono(responseType)
				.doOnTerminate(() -> logger.info("Request completed."));

	}

	private String makeURI(Request request) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(request.getURL());
		uriComponentsBuilder.queryParams(convertToMultiValueMap(request.getQueryParam()));
		logger.info("URI to execure - {}", uriComponentsBuilder.build().toString());
		return uriComponentsBuilder.build().toString();
	}

	public MultiValueMap<String, String> convertToMultiValueMap(Map<Object, Object> originalMap) {
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		for (Map.Entry<Object, Object> entry : originalMap.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			multiValueMap.add(key, value);
		}
		return multiValueMap;
	}
}
