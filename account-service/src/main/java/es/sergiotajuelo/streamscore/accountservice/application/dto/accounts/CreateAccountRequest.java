package es.sergiotajuelo.streamscore.accountservice.application.dto.accounts;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateAccountRequest(
        @NotNull(message = "User ID is mandatory")
        UUID userId,

        @NotBlank(message = "Currency is mandatory")
        @Pattern(regexp = "[A-Z]{3}", message = "Currency has to be exactly 3 uppercase letters (e.g. USD, EUR)")
        String currency
) {}
