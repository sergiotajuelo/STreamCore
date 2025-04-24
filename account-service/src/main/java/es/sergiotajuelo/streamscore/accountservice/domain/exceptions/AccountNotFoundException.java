package es.sergiotajuelo.streamscore.accountservice.domain.exceptions;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(UUID accountId) {
        super("Account" + accountId + "not found");
    }

    public AccountNotFoundException(String accountNumber) {
        super("Account" + accountNumber + "not found");
    }
}
