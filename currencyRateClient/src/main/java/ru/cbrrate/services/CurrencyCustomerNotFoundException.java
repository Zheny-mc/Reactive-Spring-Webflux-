package ru.cbrrate.services;

public class CurrencyCustomerNotFoundException extends RuntimeException {
    public CurrencyCustomerNotFoundException(String message) {
        super(message);
    }
}
