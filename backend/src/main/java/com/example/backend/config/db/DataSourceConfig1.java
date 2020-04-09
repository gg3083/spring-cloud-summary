package com.example.backend.config.db;

import com.example.backend.domain.config.DBProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author GG
 * @date 2019/1/23 13:44
 */
@Configuration
@MapperScan(basePackages ="com.example.backend.mapper1",sqlSessionFactoryRef  = "firstSqlSessionFactory")
@Slf4j
public class DataSourceConfig1 {

    @Autowired
    private DBProperties dbProperties;

    @Bean
    @Primary
    public DataSource firstDataSource() {
        log.info("db:{}",dbProperties);
        DBProperties.DBConfig config = dbProperties.getDbConfig().get(0);
        return DataSourceBuilder.create()
                .username(config.getUsername())
                .driverClassName(config.getDriverClassName())
                .password(config.getPassword())
                .url(config.getJdbcUrl())
                .build();
    }

    @Bean
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.example.backend.domain");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration( configuration );
        return bean.getObject();
    }



}
