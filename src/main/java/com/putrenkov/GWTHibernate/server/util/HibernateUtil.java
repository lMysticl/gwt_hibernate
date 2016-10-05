package com.putrenkov.GWTHibernate.server.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("userdb");
    private static EntityManager em = factory.createEntityManager();

    public static EntityManager getEntityManager() {
        return em;
    }

    public static void closeEntityManager() {
        em.close();
    }

}
