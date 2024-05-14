package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ec.edu.epn.logica.Videojuego;

import java.util.List;


public class VideojuegoDTO {
    public VideojuegoDTO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public VideojuegoDTO() {
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

    public Videojuego findVideojuego(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Videojuego.class, id);
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

    public boolean existVideojuegoByName(String tituloABuscar) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT v FROM Videojuego v WHERE v.titulo = :tituloABuscar");
            query.setParameter("tituloABuscar", tituloABuscar);
            if(query.getResultList().size() > 0){
                return true;
            }
            return false;
        } finally {
            em.close();
        }
    }

    public Videojuego findVideojuegoByName(String nombre) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT v FROM Videojuego v WHERE v.titulo = :name");
            query.setParameter("name", nombre);
            List<Videojuego> resultList = query.getResultList();
            if (resultList.size() > 0) {
                return resultList.get(0);
            } else {
                return null;
            }


        } finally {
            em.close();
        }
    }
}
