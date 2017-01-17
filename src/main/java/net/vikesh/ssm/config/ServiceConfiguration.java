package net.vikesh.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Vikesh on 24-Dec-16.
 */
@Configuration
@ComponentScan(value = {"net.vikesh.ssm.service"})
@Import(value = {ConvertersConfiguration.class})
@EnableTransactionManagement
public class ServiceConfiguration {
}
