package Persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import logica.Cliente;
import logica.Compra;
import logica.Videojuego;

import java.util.List;

public class CompraJpaController {
    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CompraJpaController() {
        emf = Persistence.createEntityManagerFactory("GR01_1BT3_622_24A_PU");
        this.emf = emf;
    }

    public void create(Compra compra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Compra compra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compra = em.find(Compra.class, id);
            if (compra != null) {
                em.remove(compra);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Compra findCompra(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public List<Compra> findAllCompras() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Compra c");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
