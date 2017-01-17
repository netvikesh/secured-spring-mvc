package net.vikesh.ssm.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Vikesh on 24-Dec-16.
 */
public class SSMAuthority implements GrantedAuthority {

    private final String name;

    public SSMAuthority(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
