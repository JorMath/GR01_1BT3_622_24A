package Persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import logica.Cliente;
import logica.Compra;
import logica.Videojuego;

import java.util.List;

public class VideojuegoJpaController {
    public VideojuegoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public VideojuegoJpaController() {
        emf = Persistence.createEntityManagerFactory("GR01_1BT3_622_24A_PU");
        this.emf = emf;
    }

    public void create(Videojuego videojuego) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(videojuego);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Videojuego videojuego) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(videojuego);
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
            Videojuego videojuego = em.find(Videojuego.class, id);
            if (videojuego != null) {
                em.remove(videojuego);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Compra findVideojuego(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public List<Videojuego> findAllVideojuego() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT v FROM Videojuego v");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
