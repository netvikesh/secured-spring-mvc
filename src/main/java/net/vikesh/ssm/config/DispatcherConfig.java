package net.vikesh.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Vikesh on 09-Dec-16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.vikesh.ssm.controller")
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver defaultViewResolver = new InternalResourceViewResolver();
        defaultViewResolver.setPrefix("/WEB-INF/jsp/views/");
        defaultViewResolver.setSuffix(".jsp");
        registry.viewResolver(defaultViewResolver);
    }

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/*").addResourceLocations("/js/");
        registry.addResourceHandler("/style/*").addResourceLocations("/css/");
        registry.addResourceHandler("/fonts/*").addResourceLocations("/fonts/");
        registry.addResourceHandler("/images/*").addResourceLocations("/images/");
    }

}
