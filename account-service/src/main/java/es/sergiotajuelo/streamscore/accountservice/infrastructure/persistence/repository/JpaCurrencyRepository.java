package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.repository;

import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCurrencyRepository extends JpaRepository<CurrencyEntity, String> {
}
