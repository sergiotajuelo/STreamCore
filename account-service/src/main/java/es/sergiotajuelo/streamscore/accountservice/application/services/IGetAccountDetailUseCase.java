package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.AccountResponse;

import java.util.UUID;

public interface IGetAccountDetailUseCase {
    AccountResponse execute(UUID accountId);
    AccountResponse execute(String accountNumber);
}
