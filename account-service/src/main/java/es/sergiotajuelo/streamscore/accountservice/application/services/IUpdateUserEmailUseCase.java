package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UpdateUserEmailRequest;
import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;

import java.util.UUID;

public interface IUpdateUserEmailUseCase {
    UserResponse execute(UUID userId, UpdateUserEmailRequest request);
}
