package es.sergiotajuelo.streamscore.accountservice.domain.ports;

import java.util.UUID;

public interface AccountValidation {
    void validateAccountCreation(UUID userId, String currencyId);
}
