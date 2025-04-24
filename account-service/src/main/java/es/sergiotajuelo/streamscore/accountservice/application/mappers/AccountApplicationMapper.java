package es.sergiotajuelo.streamscore.accountservice.application.mappers;

import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.AccountResponse;
import es.sergiotajuelo.streamscore.accountservice.domain.model.Account;
import es.sergiotajuelo.streamscore.accountservice.domain.model.Currency;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.model.enums.AccountStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {AccountStatus.class})
public interface AccountApplicationMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "userEmail", source = "user.email")
    @Mapping(target = "currency", source = "currency.id")
    @Mapping(target = "currencySymbol", source = "currency.symbol")
    AccountResponse toAccountResponse(Account account);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "accountNumber", source = "accountNumber")
    @Mapping(target = "currency", source = "currency")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createdAt", source = "currentTime")
    @Mapping(target = "updatedAt", source = "currentTime")
    @Mapping(target = "balance", source = "balance")
    Account toNewAccount(
            String accountNumber, Currency currency, User user,
            AccountStatus status, LocalDateTime currentTime,
            BigDecimal balance
    );
}