package ec.edu.epn.Servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ControladorEntidad {

    public static EntityManager getEntityManager(String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        return entityManagerFactory.createEntityManager();
    }
    public static void cerrarEntidad(EntityManager entityManager){
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
