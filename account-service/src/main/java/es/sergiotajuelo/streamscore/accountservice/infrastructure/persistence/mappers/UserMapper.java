package es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.mappers;

import es.sergiotajuelo.streamscore.accountservice.domain.model.User;
import es.sergiotajuelo.streamscore.accountservice.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "id")
    UserEntity toUserEntity(User user);

    @Mapping(target = "id", source = "userId")
    User toUser(UserEntity userEntity);
}
