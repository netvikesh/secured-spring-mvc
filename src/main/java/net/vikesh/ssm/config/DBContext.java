package net.vikesh.ssm.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by vikekumar on 009 09-Dec-16.
 */
@Configuration
public class DBContext {

    @Resource
    private Environment env;

    @Bean(destroyMethod = "close", name = "defaultDataSource")
    @AliasFor("dataSource")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(env.getProperty("database.username"));
        dataSource.setPassword(env.getProperty("database.password"));
        dataSource.setDriverClassName(env.getProperty("database.driver"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setMaxIdle(Integer.valueOf(env.getProperty("database.maxIdle")));
        dataSource.setValidationQuery(env.getProperty("database.validationQuery"));
        return dataSource;
    }

    @Bean(name = "defaultTransactionManager")
    @AliasFor("transactionManager")
    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
        transactionManager.setNestedTransactionAllowed(true);
        return transactionManager;
    }

    @Bean(name = "defaultEntityManagerFactory")
    @AliasFor("entityManagerFactory")
    @Primary
    @Resource
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[]{});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getJpaProperties());
        return em;
    }

    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", "update"));
        if (env.getProperty("deployment.environment", "develop").equalsIgnoreCase("develop")) {
            properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql", "true"));
            properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql", "true"));
        } else {
            properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql", "false"));
            properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql", "false"));
        }
        return properties;
    }

    @Bean(name = "defaultEntityManager")
    @AliasFor("entityManager")
    @Resource
    @Primary
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
}
