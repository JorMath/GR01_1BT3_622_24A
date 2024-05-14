package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Desarrollador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DesarrolladorDTO {
    public DesarrolladorDTO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DesarrolladorDTO() {
        emf = Persistence.createEntityManagerFactory("GR01_1BT3_622_24A_PU");
        this.emf = emf;
    }
    public boolean findDesarrolladorByNameAndPassword(String name, String password) {
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

    public void create(Desarrollador desarrollador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(desarrollador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Desarrollador obtenerDesarrolladorByNameAndPassword(String nombreEntrante, String claveEntrante) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT d FROM Desarrollador d WHERE d.nombre = :name AND d.clave = :password");
            query.setParameter("name", nombreEntrante);
            query.setParameter("password", claveEntrante);

            return (Desarrollador) query.getResultList().get(0);
        } finally {
            em.close();
        }
    }
}