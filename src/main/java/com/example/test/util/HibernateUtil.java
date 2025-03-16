package com.example.test.util;

import com.example.test.entity.Author;
import com.example.test.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

public final class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private HibernateUtil(){
    }

    private static SessionFactory buildSessionFactory() {
            return configure().buildSessionFactory();
    }

    private static Configuration configure() {
        return new Configuration().setProperty(AvailableSettings.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver")
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/test")
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "admin")
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "secret")
                .setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION, Action.ACTION_VALIDATE)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class);
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static Session openSession() {
        return SESSION_FACTORY.openSession();
    }
}
