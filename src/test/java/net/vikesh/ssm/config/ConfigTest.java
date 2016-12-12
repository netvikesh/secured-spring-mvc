package net.vikesh.ssm.config;

/**
 * Created by vikekumar on 012 12-Dec-16.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootContext.class})
public class ConfigTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private Environment env;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("development");
        context.register(RootContext.class);
        context.refresh();
    }

    @Test
    public void shouldRunWithoutErrors() {
        System.out.println("fdsafdas");
    }
}
