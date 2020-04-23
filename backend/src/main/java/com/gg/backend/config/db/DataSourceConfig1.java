package com.gg.backend.config.db;

import com.gg.backend.domain.config.DBProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author GG
 * @date 2019/1/23 13:44
 */
@Configuration
//@MapperScan(basePackages ="com.gg.backend.dao",sqlSessionFactoryRef  = "firstSqlSessionFactory")
@Slf4j
@EnableJpaRepositories(entityManagerFactoryRef = "jpaEntityManagerFactory",
        transactionManagerRef = "jpaTransactionManager",
        basePackages = "com.gg.backend.dao")
@EnableTransactionManagement
public class DataSourceConfig1 {

    @Autowired
    private DBProperties dbProperties;

    @Resource
    private HibernateProperties properties;

    @Resource
    private JpaProperties jpaProperties;

    @Bean
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

    @Bean(name = "jpaEntityManager")
    @Primary
    public EntityManager entityManager() {
        return entityManagerFactory().getObject().createEntityManager();

    }

    @Bean(name = "jpaEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter japVendor = new HibernateJpaVendorAdapter();
        japVendor.setGenerateDdl(false);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(firstDataSource());
        entityManagerFactory.setJpaVendorAdapter(japVendor);
        entityManagerFactory.setPackagesToScan("com.gg.backend.domain.auth");
        entityManagerFactory.setJpaPropertyMap(
                properties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings()));
        return entityManagerFactory;

    }

    @Bean(name = "jpaTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory);
        return manager;
    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceAnnotationBeanPostProcessor();
    }


}
