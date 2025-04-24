package es.sergiotajuelo.streamscore.accountservice.domain.exceptions;

public class AccountNotActiveException extends RuntimeException {
    public AccountNotActiveException() {
        super("Account not active");
    }
}
