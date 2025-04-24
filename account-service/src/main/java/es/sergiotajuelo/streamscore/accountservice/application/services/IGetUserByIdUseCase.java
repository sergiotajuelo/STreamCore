package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;

import java.util.UUID;

public interface IGetUserByIdUseCase {
    UserResponse execute(UUID userId);
}
