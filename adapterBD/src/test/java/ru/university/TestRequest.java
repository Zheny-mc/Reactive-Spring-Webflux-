package ru.university;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
public class TestRequest {

	@Test
	public void TestGetCustomer() {
		String URL = "http://localhost:8081/customer";
		Integer id = 3;
		var urlWithParams = String.format("%s/%s", URL, id);

		WebClient client = WebClient.create();

		WebClient.ResponseSpec responseSpec = client.get()
				.uri(urlWithParams)
				.retrieve();

		String responseBody = responseSpec.bodyToMono(String.class).block();

		System.out.println("response = " + responseBody);
	}


}
