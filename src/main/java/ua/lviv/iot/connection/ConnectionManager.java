package ua.lviv.iot.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import ua.lviv.iot.model.User;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class ConnectionManager {
    private static final SessionFactory sessionFactory;
    static {
      try {
        sessionFactory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        
        throw new ExceptionInInitializerError(ex);
      }
    }

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }
}
