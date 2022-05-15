package ru.university;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.util.function.BiFunction;

@RestController
public class GenerateController {


	public String runTest() {
		WebClient client = WebClient.create();
		String URL = "http://localhost:8082/api/customer/7";

		WebClient.ResponseSpec responseSpec = client.get()
				.uri(URL)
				.retrieve();

		String responseBody = responseSpec.bodyToMono(String.class).block();

		return responseBody;
	}

	public void runGen() {
		for (int i = 0; i < 200; i++) {
			runTest();
		}
	}

	@GetMapping
	public String getRun() {
		runGen();
		return "good";
	}
}
