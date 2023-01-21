package edu.psu.oneupgames.service.impl;

import edu.psu.oneupgames.model.ApplicationUser;
import edu.psu.oneupgames.repository.ApplicationUserRepository;
import edu.psu.oneupgames.service.ApplicationUserService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }


    @Override
    public ApplicationUser findByUsername(String username) {
        return applicationUserRepository.findByUsername(username);
    }
}
