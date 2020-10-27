package com.hibernateutil.config;

import com.hibernateutil.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public final class HibernateUtil {

    public static SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration();

        Properties properties = new Properties();

        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/HibernameUtil?serverTimezone=UTC&useSSL=false");

        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "1234");

        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.DEFAULT_SCHEMA, "HibernameUtil");
        properties.put(Environment.HBM2DDL_AUTO, "validate");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();


        return configuration.buildSessionFactory(serviceRegistry);
    }

}
