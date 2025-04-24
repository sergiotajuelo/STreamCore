package es.sergiotajuelo.streamscore.accountservice.domain.exceptions;

public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException(String currency) {
        super("Invalid currency: " + currency);
    }
}