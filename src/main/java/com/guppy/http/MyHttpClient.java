package com.guppy.http;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guppy.http.entity.Request;

import reactor.core.publisher.Mono;

@Service
public class MyHttpClient {

	private final WebClient webClient;

	public MyHttpClient(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
		this.webClient = webClientBuilder.build();
	}

	public <T> Mono<T> getData(Request request, Class<T> responseType) {
		return webClient.get().uri("https://catfact.ninja/breeds").retrieve().bodyToMono(responseType);
	}
}
