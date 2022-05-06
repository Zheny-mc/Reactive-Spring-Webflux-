package ru.university.client;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.web.reactive.function.client.WebClient;


public class RequestAcceptionApplication {

    private final static WebClient client = WebClient.create();

    @Benchmark
    public void testGet200Request() {
        int iterations = 1;
        for (int i = iterations; i > 0; i--) {
            runTest();
        }
    }

    public static void runTest() {
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
                .include(RequestAcceptionApplication.class.getSimpleName())
                .forks(1)
                .warmupForks(1)
                .measurementIterations(1)
                .mode(Mode.Throughput)
                .build();
        new Runner(opt).run();
    }

}
