package es.sergiotajuelo.streamscore.accountservice.domain.services;

import es.sergiotajuelo.streamscore.accountservice.application.mappers.AccountApplicationMapper;
import es.sergiotajuelo.streamscore.accountservice.domain.model.Account;
import es.sergiotajuelo.streamscore.accountservice.domain.model.Currency;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.model.enums.AccountStatus;
import es.sergiotajuelo.streamscore.accountservice.domain.ports.AccountValidation;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.CurrencyRepository;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountNumberGenerator accountNumberGenerator;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final AccountValidation accountValidation;
    private final AccountApplicationMapper accountApplicationMapper;

    public Account createAccount(UUID userId, String currencyId) {
        User user = userRepository.findById(userId);
        Currency currency = currencyRepository.findCurrencyById(currencyId);

        accountValidation.validateAccountCreation(userId, currencyId);

        return accountApplicationMapper.toNewAccount(
                accountNumberGenerator.generateAccountNumber(),
                currency,
                user,
                AccountStatus.ACTIVE,
                LocalDateTime.now(),
                BigDecimal.ZERO
        );
    }
}
