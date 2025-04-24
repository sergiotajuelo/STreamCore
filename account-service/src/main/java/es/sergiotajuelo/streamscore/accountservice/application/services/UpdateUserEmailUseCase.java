package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UpdateUserEmailRequest;
import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;
import es.sergiotajuelo.streamscore.accountservice.application.mappers.UserApplicationMapper;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.UserRepository;
import es.sergiotajuelo.streamscore.accountservice.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserEmailUseCase implements IUpdateUserEmailUseCase {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserApplicationMapper userApplicationMapper;

    @Override
    @Transactional
    public UserResponse execute(UUID userId, UpdateUserEmailRequest request) {
        User user = userRepository.findById(userId);

        User updatedUser = userService.updateEmail(user, request.email());
        User savedUser = userRepository.save(updatedUser);

        return userApplicationMapper.toUserResponse(savedUser);
    }
}
