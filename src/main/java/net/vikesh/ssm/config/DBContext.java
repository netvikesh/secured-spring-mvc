package net.vikesh.ssm.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    @Bean(destroyMethod = "close", name = "defaultDataSource")
    @AliasFor("dataSource")
    public DataSource dataSource(@Value("${database.username}") final String username,
                                 @Value("${database.driver}") String driver,
                                 @Value("${database.password}") String password,
                                 @Value("${database.url}") String url,
                                 @Value("${database.maxIdle}") int maxIdle
    ) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setMaxIdle(maxIdle);
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
        em.setPackagesToScan("net.vikesh.ssm.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getJpaProperties());
        return em;
    }

    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.format_sql", formatSql);
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