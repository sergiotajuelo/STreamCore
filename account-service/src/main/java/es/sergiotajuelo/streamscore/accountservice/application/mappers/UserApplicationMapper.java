package es.sergiotajuelo.streamscore.accountservice.application.mappers;

import es.sergiotajuelo.streamscore.accountservice.application.dto.users.UserResponse;
import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserApplicationMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    UserResponse toUserResponse(User user);
}
