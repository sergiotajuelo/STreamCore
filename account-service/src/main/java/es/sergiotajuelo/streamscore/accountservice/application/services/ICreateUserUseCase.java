package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.CreateUserRequest;
import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;

public interface ICreateUserUseCase {
    UserResponse execute(CreateUserRequest request);
}
