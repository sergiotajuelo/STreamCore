package es.sergiotajuelo.streamscore.accountservice.domain.repository;


import es.sergiotajuelo.streamscore.accountservice.domain.model.Currency;

public interface CurrencyRepository {
    Currency findCurrencyById(String currencyId);
}
