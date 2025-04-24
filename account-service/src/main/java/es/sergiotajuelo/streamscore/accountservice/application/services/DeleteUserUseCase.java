package es.sergiotajuelo.streamscore.accountservice.application.services;

import es.sergiotajuelo.streamscore.accountservice.application.services.IDeleteUserUseCase;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.domain.repository.UserRepository;
import es.sergiotajuelo.streamscore.accountservice.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCase implements IDeleteUserUseCase {

    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void execute(UUID userId) {
        User user = userRepository.findById(userId);
        userService.deleteUser(user);
        userRepository.save(user);
    }
}
