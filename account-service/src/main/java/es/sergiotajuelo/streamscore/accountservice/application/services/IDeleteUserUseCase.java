package es.sergiotajuelo.streamscore.accountservice.application.services;

import java.util.UUID;

public interface IDeleteUserUseCase {
    void execute(UUID userId);
}
