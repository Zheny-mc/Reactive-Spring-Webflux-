package ru.university;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.web.reactive.function.client.WebClient;

public class JMHBenchmarking {
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void doExection() {
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

	public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHBenchmarking.class.getSimpleName())
                .forks(2)
                .build();
        new Runner(opt).run();

	}


}