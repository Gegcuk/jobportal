package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gegc.jobportal.entity.UsersType;

import java.util.List;

@Repository
public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {

}
