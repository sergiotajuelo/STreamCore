package es.sergiotajuelo.streamscore.accountservice.domain.ports;

import es.sergiotajuelo.streamscore.accountservice.domain.model.User;

public interface UpdateEmailUser {
    User updateEmail(User user, String newEmail);
}
