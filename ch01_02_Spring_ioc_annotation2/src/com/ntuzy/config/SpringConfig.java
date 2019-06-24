package com.ntuzy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring≈‰÷√¿‡ ¥˙ÃÊapplicationContext.xml
 * 
 * @author iamzy
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.ntuzy" })
@Import(value = { JdbcProperties.class })
public class SpringConfig {

}
