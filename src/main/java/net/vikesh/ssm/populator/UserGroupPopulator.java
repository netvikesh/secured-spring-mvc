package net.vikesh.ssm.populator;

import net.vikesh.ssm.model.SSMAuthority;
import net.vikesh.ssm.model.site.UserGroup;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Vikesh on 24-Dec-16.
 */
public class UserGroupPopulator implements Populator<UserGroup, GrantedAuthority> {

    @Override
    public GrantedAuthority populate(UserGroup group, GrantedAuthority authority) {
        return new SSMAuthority(group.getGroupName().toUpperCase());
    }
}
