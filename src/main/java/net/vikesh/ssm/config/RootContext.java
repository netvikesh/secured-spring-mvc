package net.vikesh.ssm.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Vikesh on 09-Dec-16.
 */
@Configuration
@Import(DBContext.class)
public class RootContext {

    @Bean
    @Profile("development")
    public static PropertyPlaceholderConfigurer development() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("classpath:/junit.properties"));
        return configurer;
    }

    @Bean
    @Profile("production")
    public static PropertyPlaceholderConfigurer production() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("classpath:/project.properties"));
        return configurer;
    }
}
