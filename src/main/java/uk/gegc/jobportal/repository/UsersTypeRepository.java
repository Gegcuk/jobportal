package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gegc.jobportal.entity.UsersType;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {
}
