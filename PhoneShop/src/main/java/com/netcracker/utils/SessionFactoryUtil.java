package com.netcracker.utils;

import com.netcracker.entities.Phone;
import com.netcracker.entities.PhoneFeatures;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private SessionFactoryUtil(){}

    @Bean
    public static Session getSession(){
        if (sessionFactory == null) {
//            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Phone.class);
                configuration.addAnnotatedClass(PhoneFeatures.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
/*            } catch (Exception e) {
                //System.out.println("Исключение!" + e);
            }*/
        }
        return sessionFactory.openSession();
    }

}
