package com.gg.backend.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @author Gimi
 * @date 2020/4/9 17:33
 */
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix="spring.datasource")
@Data
@Configuration
public class DBProperties {

    private List<DBConfig> dbConfig;

    @Data
    public static class DBConfig {
        private String jdbcUrl;
        private String driverClassName;
        private String username;
        private String password;
    }

}
