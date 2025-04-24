package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.AccountResponse;
import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.CreateAccountRequest;
import es.sergiotajuelo.streamscore.accountservice.application.mappers.AccountApplicationMapper;
import es.sergiotajuelo.streamscore.accountservice.domain.exceptions.InvalidAccountOperationException;
import es.sergiotajuelo.streamscore.accountservice.domain.model.Account;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.AccountRepository;
import es.sergiotajuelo.streamscore.accountservice.domain.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final AccountApplicationMapper accountApplicationMapper;

    @Override
    public AccountResponse execute(CreateAccountRequest request) {
        try {
            Account account = accountService.createAccount(request.userId(), request.currency());
            account = accountRepository.save(account);
            return accountApplicationMapper.toAccountResponse(account);
        } catch (EntityNotFoundException e) {
            throw new InvalidAccountOperationException("No se pudo crear la cuenta: " + e.getMessage());
        }
    }
}
