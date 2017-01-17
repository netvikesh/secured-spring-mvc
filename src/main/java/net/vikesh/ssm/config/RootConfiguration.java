package net.vikesh.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

/**
 * Created by Vikesh on 09-Dec-16.
 */
@Configuration
@Import(value = {SecurityConfiguration.class, PersistenceConfiguration.class, ServiceConfiguration.class})
public class RootConfiguration {

    @Resource
    private Environment environment;

    @Bean
    @Profile("development")
    public static PropertySourcesPlaceholderConfigurer development() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("junit.properties"));
        return configurer;
    }

    @Bean
    @Profile(value = "default")
    public static PropertySourcesPlaceholderConfigurer production() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("project.properties"));
        return configurer;
    }
}
