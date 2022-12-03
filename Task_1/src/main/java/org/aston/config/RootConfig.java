package org.aston.config;

import org.aston.service.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.aston")
@PropertySource({"database.properties"})
public class RootConfig {

    @Bean
    public Admin admin(){
        return new Admin();
    }
}
