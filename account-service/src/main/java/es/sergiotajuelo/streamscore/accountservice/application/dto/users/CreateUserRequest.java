package es.sergiotajuelo.streamscore.accountservice.application.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank String name,
        @NotBlank @Email String email
) {
}