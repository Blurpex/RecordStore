package edu.psu.oneupgames.model.security;

import edu.psu.oneupgames.model.ApplicationUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityUser extends ApplicationUser implements UserDetails {
    public SecurityUser(ApplicationUser user) {
        if (user != null) {
            this.userId = user.getUserId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.isAdmin = user.getAdmin();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        var authority = new SimpleGrantedAuthority("USER");
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
