package net.vikesh.ssm.populator;

import net.vikesh.ssm.model.SSMUserDetails;
import net.vikesh.ssm.model.site.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Vikesh on 24-Dec-16.
 */
@Component
public class UserDetailsPopulator implements Populator<User, UserDetails> {

    @Override
    public UserDetails populate(User user, UserDetails userDetails) {
        return new SSMUserDetails(null, new String(user.getPassword()), user.getUsername(), !user.isAccountExpired(), !user.isAccountLocked(), !user.isPasswordExpired(), user.isEnabled());
    }
}
