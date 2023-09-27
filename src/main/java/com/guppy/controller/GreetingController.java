package com.guppy.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guppy.entity.Greeting;
import com.guppy.http.MyHttpClient;
import com.guppy.http.entity.HTTPRequestType;
import com.guppy.http.entity.Request;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	MyHttpClient httpClient;
	@Autowired
	ObjectMapper objectMapper;

//	public GreetingController(MyHttpClient myHttpClient) {
//		this.httpClient = myHttpClient;
//	}

	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		Map<Object, Object> qp = new HashMap<>();
		qp.put("limit", 10);
		Request request = Request.builder().URL("https://catfact.ninja/breeds").queryParam(qp)
				.requestType(HTTPRequestType.GET).build();
		Request request2 = Request.builder().URL("https://reqres.in/api/users").requestType(HTTPRequestType.POST)
				.requestBody("{\"name\": \"morpheus\",\"job\": \"leader\"}").build();
		httpClient.makeEndpointCall(request2, Object.class).subscribe(response -> {
			logger.info("Response - " + response);
		});

		return new Greeting(counter.incrementAndGet(), "HAHA");
	}
}