package edu.psu.oneupgames.repository;

import edu.psu.oneupgames.model.ApplicationUser;

public interface ApplicationUserRepository {
    ApplicationUser findByUsername(String username);

    void addUser(ApplicationUser applicationUser);
}
