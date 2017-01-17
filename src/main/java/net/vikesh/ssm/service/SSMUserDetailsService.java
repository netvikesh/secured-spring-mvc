package net.vikesh.ssm.service;

import net.vikesh.ssm.SSMUtils;
import net.vikesh.ssm.dao.Dao;
import net.vikesh.ssm.model.site.User;
import net.vikesh.ssm.populator.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vikesh on 24-Dec-16.
 */
@Service
public class SSMUserDetailsService implements UserDetailsService {

    @Resource
    private EntityManager em;

    @Resource
    private Converter<User, UserDetails> userDetailsConverter;

    @Resource
    private Dao<User> userDao;

    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        Map<String, String> searchParams = new HashMap<>();
        if (SSMUtils.isEmail(userNameOrEmail)) {
            searchParams.put(User.EMAIL, userNameOrEmail);
        } else {
            searchParams.put(User.USERNAME, userNameOrEmail);
        }
        User user = userDao.searchOne(User.class, searchParams);
        if (user != null) {
            return userDetailsConverter.convert(user);
        }
        throw new UsernameNotFoundException(String.format("User with userNameOrEmail:%s not found", userNameOrEmail));
    }
}
