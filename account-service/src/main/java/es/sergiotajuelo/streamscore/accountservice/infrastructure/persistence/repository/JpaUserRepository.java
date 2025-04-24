package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.repository;

import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByEmail(String email);
}
