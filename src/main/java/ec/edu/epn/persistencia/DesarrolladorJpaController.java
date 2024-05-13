package ec.edu.epn.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DesarrolladorJpaController {
    public DesarrolladorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DesarrolladorJpaController() {
        emf = Persistence.createEntityManagerFactory("GR01_1BT3_622_24A_PU");
        this.emf = emf;
    }
    public boolean findClienteByNameAndPassword(String name, String password) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT d FROM Desarrollador d WHERE d.nombre = :name AND d.clave = :password");
            query.setParameter("name", name);
            query.setParameter("password", password);
            if(query.getResultList().size() > 0){
                return true;
            }
            return false;
        } finally {
            em.close();
        }
    }
}
