package org.aston;

import org.aston.config.HibernateConfig;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {

      SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

    }
}