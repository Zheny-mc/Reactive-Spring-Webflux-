package ru.university.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_ggg {
    private final WebClient client = WebClient.create();
    private String URL = "http://localhost:8082/api/customer/70";
    @Test
    public void manyThread() {
        final int SIZE_POOL = 5000;
        Callable<String> task = () -> runTest();
        ExecutorService service = Executors.newFixedThreadPool(SIZE_POOL);

        for (int i = 0; i < SIZE_POOL; i++) {
            Future result = service.submit(task);

            try {
                Assertions.assertEquals(result.get(), "{\"id\":70,\"name\":\"testPut1\"}");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    public String runTest() {
        WebClient.ResponseSpec responseSpec = client.get()
                .uri(URL)
                .retrieve();

        String responseBody = responseSpec.bodyToMono(String.class).block();

        return responseBody;
    }
}
