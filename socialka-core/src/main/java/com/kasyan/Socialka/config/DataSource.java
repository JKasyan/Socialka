package com.kasyan.Socialka.config;

import com.kasyan.Socialka.dto.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.util.Properties;

/**
 * Created by Victoriya on 17.02.16.
 */
@Configuration
public class DataSource {

    private static final String DB_URL =
            "jdbc:postgres://localhost/postgres?characterEncoding=UTF-8&amp;Unicode=true&amp;keepAlive=true";
    private static final Class<?> ANNOTATED_CLASSES[] = {
            User.class, Friendship.class, Group.class, Image.class, SmallImage.class, UserRole.class
    };

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(DB_URL);
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(driverManagerDataSource());
        factoryBean.setAnnotatedClasses(ANNOTATED_CLASSES);
        Properties pr = new Properties();
        pr.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        pr.setProperty("hibernate.current_session_context_class", "thread");
        pr.setProperty("hibernate.show_sql", "true");
        factoryBean.setHibernateProperties(pr);
        return factoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
