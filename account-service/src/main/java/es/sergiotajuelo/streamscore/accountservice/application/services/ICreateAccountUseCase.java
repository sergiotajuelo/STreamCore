package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.AccountResponse;
import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.CreateAccountRequest;

public interface ICreateAccountUseCase {
    AccountResponse execute(CreateAccountRequest request);
}
