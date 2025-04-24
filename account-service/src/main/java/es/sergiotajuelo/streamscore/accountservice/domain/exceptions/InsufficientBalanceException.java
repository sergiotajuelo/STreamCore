package es.sergiotajuelo.streamscore.accountservice.domain.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("Insufficient balance for this operation");
    }
}
