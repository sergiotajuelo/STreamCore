package es.sergiotajuelo.streamscore.accountservice.domain.ports;

import es.sergiotajuelo.streamscore.accountservice.domain.model.User;

public interface DeleteUser {
    void deleteUser(User user);
}
