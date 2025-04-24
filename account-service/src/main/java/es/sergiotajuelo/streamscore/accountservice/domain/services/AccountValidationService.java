package es.sergiotajuelo.streamscore.accountservice.domain.services;

import es.sergiotajuelo.streamscore.accountservice.domain.exceptions.InvalidAccountOperationException;
import es.sergiotajuelo.streamscore.accountservice.domain.model.Account;
import es.sergiotajuelo.streamscore.accountservice.domain.ports.AccountValidation;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountValidationService implements AccountValidation {
    private final AccountRepository accountRepository;

    @Override
    public void validateAccountCreation(UUID userId, String currencyId) {
        Optional<Account> existingAccountOpt = accountRepository.findByUserIdAndCurrency(userId, currencyId);
        if (existingAccountOpt.isPresent()) {
            throw new InvalidAccountOperationException("User already has an account with currency " + currencyId);
        }
    }
}
