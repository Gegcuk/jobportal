package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gegc.jobportal.entity.Users;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
