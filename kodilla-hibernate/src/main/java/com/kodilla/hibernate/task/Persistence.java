package com.kodilla.hibernate.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class Persistence {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource =  new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw&useSSL=False&allowPublicKeyRetrieval=true");
        dataSource.setUsername("kodilla-user");
        dataSource.setPassword("kodilla_Pass123");

        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(dataSource());
       sessionFactory.setPackagesToScan("com.kodilla.hibernate");
       Properties hibernateProperties = new Properties();
       hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
       hibernateProperties.put("hibernate.show_sql", "true");
       sessionFactory.setHibernateProperties(hibernateProperties);

       return sessionFactory;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManagerHibernate() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());

        return hibernateTransactionManager;
    }
}
