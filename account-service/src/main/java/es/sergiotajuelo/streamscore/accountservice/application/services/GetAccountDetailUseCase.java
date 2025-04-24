package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.AccountResponse;
import es.sergiotajuelo.streamscore.accountservice.application.mappers.AccountApplicationMapper;
import es.sergiotajuelo.streamscore.accountservice.domain.exceptions.AccountNotFoundException;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAccountDetailUseCase implements IGetAccountDetailUseCase {

    private final AccountRepository accountRepository;
    private final AccountApplicationMapper accountApplicationMapper;

    @Override
    public AccountResponse execute(UUID accountId) {
        return accountRepository.findById(accountId)
                .map(accountApplicationMapper::toAccountResponse)
                .orElseThrow(() -> new AccountNotFoundException(accountId));
    }

    @Override
    public AccountResponse execute(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(accountApplicationMapper::toAccountResponse)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }
}
