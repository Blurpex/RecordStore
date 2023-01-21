package edu.psu.oneupgames.service.security;

import edu.psu.oneupgames.model.ApplicationUser;
import edu.psu.oneupgames.model.security.SecurityUser;
import edu.psu.oneupgames.service.ApplicationUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final ApplicationUserService applicationUserService;

    public ApplicationUserDetailsService(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserService.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("user with username not found " + username);
        }
        return new SecurityUser(user);
    }
}
