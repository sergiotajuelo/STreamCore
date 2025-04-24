package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.mappers;

import es.sergiotajuelo.streamscore.accountservice.domain.model.Currency;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.CurrencyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    @Mapping(target = "currencyId", source = "id")
    CurrencyEntity toCurrencyEntity(Currency currency);

    @Mapping(target = "id", source = "currencyId")
    Currency toCurrency(CurrencyEntity currencyEntity);
}