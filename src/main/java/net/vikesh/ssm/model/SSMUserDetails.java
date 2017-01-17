package net.vikesh.ssm.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vikesh on 24-Dec-16.
 */
public class SSMUserDetails implements UserDetails {

    private final Collection<GrantedAuthority> grantedAuthorities;
    private final String password;
    private final String userName;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public SSMUserDetails(final List<GrantedAuthority> authorities,
                          final String password,
                          final String userName,
                          final boolean isAccountNonExpired,
                          final boolean isAccountNonLocked,
                          final boolean isCredentialNonExpired,
                          final boolean isEnabled) {
        List<GrantedAuthority> authorityList = new ArrayList<>(authorities);
        this.grantedAuthorities = authorityList;
        this.password = password;
        this.userName = userName;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
