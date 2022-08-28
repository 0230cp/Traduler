package cp.Traduler.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


public class SecurityDetails implements UserDetails {
    private User SecurityUser;

    public SecurityDetails(User SecurityUser){
        this.SecurityUser = SecurityUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        Role role;
        if("rhwo84".equals(SecurityUser.getId())){role = Role.ROLE_ADMIN;}
        else {role=Role.ROLE_USER;}
        collection.add(new SimpleGrantedAuthority(role.getValue()));
        return collection;
    }


    @Override
    public String getPassword() {
        return SecurityUser.getPw();
    }

    @Override
    public String getUsername() {
        return SecurityUser.getId();
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
