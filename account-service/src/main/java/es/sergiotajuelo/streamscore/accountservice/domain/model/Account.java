package es.sergiotajuelo.streamscore.accountservice.domain.model;

import es.sergiotajuelo.streamscore.accountservice.domain.model.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private UUID id;
    private User user;
    private Currency currency;
    private BigDecimal balance;
    private String accountNumber;
    private AccountStatus status;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}