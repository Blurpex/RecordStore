package edu.psu.oneupgames.jpa;

import edu.psu.oneupgames.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface JpaApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
