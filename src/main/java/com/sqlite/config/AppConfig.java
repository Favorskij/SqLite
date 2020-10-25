package com.sqlite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.sqlite.repository")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:sqlite:db/SpringDB.db");
    }
}
