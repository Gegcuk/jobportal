package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gegc.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
