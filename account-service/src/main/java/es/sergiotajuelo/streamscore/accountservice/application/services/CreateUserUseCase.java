package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.CreateUserRequest;
import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;
import es.sergiotajuelo.streamscore.accountservice.application.mappers.UserApplicationMapper;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.ports.CreateUser;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements ICreateUserUseCase {

    private final CreateUser createUser;
    private final UserRepository userRepository;
    private final UserApplicationMapper userApplicationMapper;

    @Override
    @Transactional
    public UserResponse execute(CreateUserRequest request) {
        User user = createUser.create(request.name(), request.email());
        User savedUser = userRepository.save(user);
        return userApplicationMapper.toUserResponse(savedUser);
    }
}
