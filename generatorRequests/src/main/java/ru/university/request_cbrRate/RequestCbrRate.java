package ru.university.request_cbrRate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestCbrRate {

    @Bean
    public String testGenerator(@Value("${number}") int value) {
        System.out.println("Test Bean" + value);
        return String.format("%d", value);
    }

    @Bean
    public Integer testGeneratorInteger(String number) {
        System.out.println("Test number" + number);
        return Integer.parseInt(number);
    }
}
