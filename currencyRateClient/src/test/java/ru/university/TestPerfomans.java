package ru.university;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPerfomans {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void dataTest() {
        var number = 55;
        //when
        var result = webTestClient
                .get().uri(String.format("/api/customer/%d", number))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(String.class)
                .getResponseBody()
                .blockLast();

        assertEquals(result, 3);
    }
}
