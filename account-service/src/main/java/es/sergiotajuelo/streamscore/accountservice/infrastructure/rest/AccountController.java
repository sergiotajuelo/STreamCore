package es.sergiotajuelo.streamscore.accountservice.infrastructure.rest;

import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.AccountResponse;
import es.sergiotajuelo.streamscore.accountservice.application.dto.accounts.CreateAccountRequest;
import es.sergiotajuelo.streamscore.accountservice.application.services.ICreateAccountUseCase;
import es.sergiotajuelo.streamscore.accountservice.application.services.IGetAccountDetailUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final ICreateAccountUseCase createAccountUseCase;
    private final IGetAccountDetailUseCase getAccountDetailUseCase;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        AccountResponse response = createAccountUseCase.execute(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccountDetail(@PathVariable UUID accountId) {
        AccountResponse response = getAccountDetailUseCase.execute(accountId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<AccountResponse> getAccountDetailByAccountNumber(@RequestParam String accountNumber) {
        AccountResponse response = getAccountDetailUseCase.execute(accountNumber);
        return ResponseEntity.ok(response);
    }
}