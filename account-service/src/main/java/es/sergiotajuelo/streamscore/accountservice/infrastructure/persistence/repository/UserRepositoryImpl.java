package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.repository;

import es.sergiotajuelo.streamscore.accountservice.domain.exceptions.BusinessException;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.UserRepository;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.UserEntity;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        UserEntity savedEntity = jpaUserRepository.save(userEntity);
        return userMapper.toUser(savedEntity);
    }

    @Override
    public User findById(UUID userId) {
        UserEntity userEntity = jpaUserRepository.findById(userId)
                .orElseThrow( () -> new BusinessException("User not found"));
        return userMapper.toUser(userEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }
}
