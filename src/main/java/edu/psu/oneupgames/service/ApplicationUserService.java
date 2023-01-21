package edu.psu.oneupgames.service;

import edu.psu.oneupgames.model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findByUsername(String username);
}
