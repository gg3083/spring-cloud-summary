package com.gg.backend.config.db;

import com.gg.backend.domain.config.DBProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@MapperScan(basePackages ="com.gg.backend.mapper2",sqlSessionFactoryRef  = "secondSqlSessionFactory")
public class DataSourceConfig2 {

    @Autowired
    private DBProperties dbProperties;

    @Bean
    @Primary
    public DataSource secondDataSource() {
        DBProperties.DBConfig config = dbProperties.getDbConfig().get(1);
        return DataSourceBuilder.create()
                .username(config.getUsername())
                .driverClassName(config.getDriverClassName())
                .password(config.getPassword())
                .url(config.getJdbcUrl())
                .build();
    }

    @Bean
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.gg.backend.domain");
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration( configuration );
        return bean.getObject();
    }


}
