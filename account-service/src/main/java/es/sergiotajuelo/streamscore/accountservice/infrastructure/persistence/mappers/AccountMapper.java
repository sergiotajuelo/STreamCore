package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.mappers;

import es.sergiotajuelo.streamscore.accountservice.domain.model.Account;
import es.sergiotajuelo.streamscore.accountservice.domain.model.enums.AccountStatus;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.AccountEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, CurrencyMapper.class},
        imports = {AccountStatus.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountMapper {

    @Mapping(target = "accountId", source = "id")
    @Mapping(target = "status", expression = "java(accountEntity.getStatus())")
    AccountEntity toAccountEntity(Account account);

    @Mapping(target = "id", source = "accountId")
    @Mapping(target = "status", expression = "java(AccountStatus.valueOf(accountEntity.getStatus()))")
    Account toAccount(AccountEntity accountEntity);
}