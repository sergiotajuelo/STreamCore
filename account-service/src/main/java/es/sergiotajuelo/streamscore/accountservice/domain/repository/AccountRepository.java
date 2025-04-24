package es.sergiotajuelo.streamscore.accountservice.domain.repository;

import es.sergiotajuelo.streamscore.accountservice.domain.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(UUID id);
    Optional<Account> findByAccountNumber(String accountNumber);
    Optional<Account> findByUserIdAndCurrency(UUID userId, String currencyId);
}
