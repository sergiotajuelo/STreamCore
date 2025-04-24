package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.repository;

import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, UUID> {
    Optional<AccountEntity> findByUser_UserIdAndCurrency_CurrencyId(UUID userUserId, String currencyId);

    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}
