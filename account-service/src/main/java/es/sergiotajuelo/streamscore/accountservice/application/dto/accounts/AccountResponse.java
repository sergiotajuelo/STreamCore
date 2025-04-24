package es.sergiotajuelo.streamscore.accountservice.application.dto.accounts;

import es.sergiotajuelo.streamscore.accountservice.domain.model.enums.AccountStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record AccountResponse(
        UUID id,
        String accountNumber,
        UUID userId,
        String userName,
        String userEmail,
        String currency,
        String currencySymbol,
        BigDecimal balance,
        AccountStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }
