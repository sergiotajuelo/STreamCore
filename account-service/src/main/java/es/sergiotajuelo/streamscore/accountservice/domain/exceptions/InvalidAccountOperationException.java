package es.sergiotajuelo.streamscore.accountservice.domain.exceptions;

public class InvalidAccountOperationException extends RuntimeException {
    public InvalidAccountOperationException(String message) {
        super(message);
    }
}
