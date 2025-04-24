package es.sergiotajuelo.streamscore.accountservice.domain.repository;

import es.sergiotajuelo.streamscore.accountservice.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    User findById(UUID userId);
    List<User> findAllByIds(List<UUID> ids);
    boolean existsByEmail(String email);

}
