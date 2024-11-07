package uk.gegc.jobportal.service;

import uk.gegc.jobportal.entity.Users;

import java.util.Optional;

public interface UsersService {
    public Users addNew(Users users);

    Optional<Users> getUserByEmail(String email);
}
