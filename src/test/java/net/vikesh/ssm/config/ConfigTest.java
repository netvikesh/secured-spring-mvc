package net.vikesh.ssm.config;

/**
 * Created by vikekumar on 012 12-Dec-16.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = "development")
@ContextConfiguration(classes = {RootContext.class})
public class ConfigTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private Environment env;

    @Test
    public void shouldRunWithoutErrors() {
    }
}
