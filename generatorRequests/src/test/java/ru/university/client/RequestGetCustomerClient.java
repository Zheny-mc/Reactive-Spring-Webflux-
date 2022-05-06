package ru.university.client;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.web.reactive.function.client.WebClient;

public class RequestGetCustomerClient {

	private final static WebClient client = WebClient.create();

	@Benchmark
	@Fork(value = 5, warmups = 2)
	@BenchmarkMode(Mode.AverageTime)
	public void getRequests() {
		String URL = "http://localhost:8082/api/customer";
		Integer id = 70;
		var urlWithParams = String.format("%s/%s", URL, id);

		WebClient.ResponseSpec responseSpec = client.get()
				.uri(urlWithParams)
				.retrieve();

		String responseBody = responseSpec.bodyToMono(String.class).block();

		System.out.println("response = " + responseBody);
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(RequestGetCustomerClient.class.getSimpleName())
				.forks(1)
				.build();
		new Runner(opt).run();
	}
}