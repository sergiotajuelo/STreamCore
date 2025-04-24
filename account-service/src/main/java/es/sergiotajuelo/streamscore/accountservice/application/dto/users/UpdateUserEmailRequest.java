package es.sergiotajuelo.streamscore.accountservice.application.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserEmailRequest(
        @NotBlank @Email String email
) {
}
