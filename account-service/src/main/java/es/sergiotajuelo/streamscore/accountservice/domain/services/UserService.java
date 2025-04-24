package es.sergiotajuelo.streamscore.accountservice.domain.services;

import es.sergiotajuelo.streamscore.accountservice.domain.exceptions.BusinessException;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.model.enums.UserStatus;
import es.sergiotajuelo.streamscore.accountservice.domain.ports.CreateUser;
import es.sergiotajuelo.streamscore.accountservice.domain.ports.DeleteUser;
import es.sergiotajuelo.streamscore.accountservice.domain.ports.UpdateEmailUser;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements CreateUser, UpdateEmailUser, DeleteUser {

    private final UserRepository userRepository;

    @Override
    public User create(String name, String email) {
        if (userRepository.existsByEmail(email)) {
            throw new BusinessException("Email already in use: " + email);
        }

        return User.builder()
                .id(UUID.randomUUID())
                .name(name)
                .email(email)
                .status(UserStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public User updateEmail(User user, String newEmail) {
        if (!user.getEmail().equals(newEmail) && userRepository.existsByEmail(newEmail)) {
            throw new BusinessException("Email already in use: " + newEmail);
        }

        user.setEmail(newEmail);
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

    @Override
    public void deleteUser(User user) {
        user.setStatus(UserStatus.INACTIVE);
        user.setUpdatedAt(LocalDateTime.now());
    }
}