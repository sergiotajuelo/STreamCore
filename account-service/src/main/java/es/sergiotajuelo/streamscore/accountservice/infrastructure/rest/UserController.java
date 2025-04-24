package es.sergiotajuelo.streamscore.accountservice.infrastructure.rest;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.CreateUserRequest;
import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UpdateUserEmailRequest;
import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;
import es.sergiotajuelo.streamscore.accountservice.application.services.ICreateUserUseCase;
import es.sergiotajuelo.streamscore.accountservice.application.services.IDeleteUserUseCase;
import es.sergiotajuelo.streamscore.accountservice.application.services.IGetUserByIdUseCase;
import es.sergiotajuelo.streamscore.accountservice.application.services.IUpdateUserEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final ICreateUserUseCase createUserUseCase;
    private final IGetUserByIdUseCase getUserByIdUseCase;
    private final IDeleteUserUseCase deleteUserUseCase;
    private final IUpdateUserEmailUseCase updateUserEmailUseCase;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserResponse response = createUserUseCase.execute(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID userId) {
        UserResponse response = getUserByIdUseCase.execute(userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        deleteUserUseCase.execute(userId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{userId}/email")
    public ResponseEntity<UserResponse> updateUserEmail(
            @PathVariable UUID userId,
            @RequestBody UpdateUserEmailRequest request) {
        UserResponse response = updateUserEmailUseCase.execute(userId, request);
        return ResponseEntity.ok(response);
    }
}