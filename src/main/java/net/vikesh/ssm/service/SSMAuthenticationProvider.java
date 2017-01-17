package net.vikesh.ssm.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Vikesh on 23-Dec-16.
 */
@Service
public class SSMAuthenticationProvider implements AuthenticationProvider {
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = (String) authentication.getPrincipal();
        final char[] password = ((String) authentication.getCredentials()).toCharArray();
        if (password == null || password.length == 0) {
            return null;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String savedPassword = userDetails.getPassword();
        if (savedPassword.equals(encoded(password))) {

            for (int i = 0; i < password.length; i++) {
                password[i] = '0';
            }
            return buildAuthentication(userDetails);
        }
        return null;
    }

    /**
     * Creates an Authentication from the provided user details. NOTE: Cannot use Converter to do this as
     * details need to be passed in Constructor of the Authentication.
     *
     * @param userDetails
     * @return
     */
    private Authentication buildAuthentication(UserDetails userDetails) {
        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
    }

    private char[] encoded(char[] password) {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
