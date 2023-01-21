package edu.psu.oneupgames.repository.impl;

import edu.psu.oneupgames.jpa.JpaApplicationUserRepository;
import edu.psu.oneupgames.model.ApplicationUser;
import edu.psu.oneupgames.repository.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    private final JpaApplicationUserRepository jpaApplicationUserRepository;

    public ApplicationUserRepositoryImpl(JpaApplicationUserRepository jpaApplicationUserRepository) {
        this.jpaApplicationUserRepository = jpaApplicationUserRepository;
    }

    @Override
    public ApplicationUser findByUsername(String username) {
        return jpaApplicationUserRepository.findByUsername(username);
    }

    @Override
    public void addUser(ApplicationUser applicationUser) {
        jpaApplicationUserRepository.save(applicationUser);
    }
}
