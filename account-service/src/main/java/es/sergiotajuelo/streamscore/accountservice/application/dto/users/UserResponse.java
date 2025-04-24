package es.sergiotajuelo.streamscore.accountservice.application.dto.users;

import es.sergiotajuelo.streamscore.accountservice.domain.model.enums.UserStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        String name,
        String email,
        UserStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
