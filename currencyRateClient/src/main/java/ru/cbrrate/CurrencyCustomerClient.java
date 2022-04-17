package ru.cbrrate;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
public class CurrencyCustomerClient {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(CurrencyCustomerClient.class).run(args);
    }
}
