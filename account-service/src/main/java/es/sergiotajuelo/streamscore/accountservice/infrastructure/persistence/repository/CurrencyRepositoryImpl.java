package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.repository;

import es.sergiotajuelo.streamscore.accountservice.domain.model.Currency;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.CurrencyRepository;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.CurrencyEntity;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.mappers.CurrencyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CurrencyRepositoryImpl implements CurrencyRepository {

    private final JpaCurrencyRepository jpaCurrencyRepository;
    private final CurrencyMapper currencyMapper;

    @Override
    public Currency findCurrencyById(String currencyId) {
        CurrencyEntity currency = jpaCurrencyRepository.findById(currencyId)
                .orElseThrow(() -> new IllegalArgumentException("Currency not found"));
        return currencyMapper.toCurrency(currency);
    }
}
