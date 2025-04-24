package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.repository;

import es.sergiotajuelo.streamscore.accountservice.domain.model.Account;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.AccountRepository;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.AccountEntity;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.mappers.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final JpaAccountRepository jpaAccountRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = accountMapper.toAccountEntity(account);
        accountEntity = jpaAccountRepository.save(accountEntity);
        return accountMapper.toAccount(accountEntity);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return jpaAccountRepository.findById(id)
                .map(accountMapper::toAccount);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return jpaAccountRepository.findByAccountNumber(accountNumber)
                .map(accountMapper::toAccount);
    }

    @Override
    public Optional<Account> findByUserIdAndCurrency(UUID userId, String currencyId) {
        return jpaAccountRepository.findByUser_UserIdAndCurrency_CurrencyId(userId, currencyId)
                .map(accountMapper::toAccount);
    }
}
