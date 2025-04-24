package es.sergiotajuelo.streamscore.accountservice.domain.repository;

import es.sergiotajuelo.streamscore.accountservice.domain.model.User;

import java.util.UUID;

public interface UserRepository {
    User save(User user);
    User findById(UUID userId);
    boolean existsByEmail(String email);

}
