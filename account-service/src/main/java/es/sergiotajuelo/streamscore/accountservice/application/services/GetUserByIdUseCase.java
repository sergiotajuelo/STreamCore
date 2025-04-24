package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;
import es.sergiotajuelo.streamscore.accountservice.application.mappers.UserApplicationMapper;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase implements IGetUserByIdUseCase {

    private final UserRepository userRepository;
    private final UserApplicationMapper userApplicationMapper;

    @Override
    @Transactional(readOnly = true)
    public UserResponse execute(UUID userId) {
        User user = userRepository.findById(userId);
        return userApplicationMapper.toUserResponse(user);
    }
}
