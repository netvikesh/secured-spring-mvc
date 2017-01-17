package net.vikesh.ssm.config;

import net.vikesh.ssm.model.site.User;
import net.vikesh.ssm.populator.Converter;
import net.vikesh.ssm.populator.Populator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by Vikesh on 24-Dec-16.
 */
@Configuration
@ComponentScan(value = {"net.vikesh.ssm.populator"})
public class ConvertersConfiguration {

    @Bean
    public Converter<User, UserDetails> userDetailsConverter(List<Populator<User, UserDetails>> populatorList) {
        return new Converter<>(populatorList);
    }
}
