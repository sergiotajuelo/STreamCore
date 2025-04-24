package es.sergiotajuelo.streamscore.accountservice.domain.ports;

import es.sergiotajuelo.streamscore.accountservice.domain.model.User;

public interface CreateUser {
    User create(String name, String email);
}
