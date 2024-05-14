package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ec.edu.epn.logica.Compra;

import java.util.Date;
import java.util.List;

public class CompraDTO {
    public CompraDTO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CompraDTO() {
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

    public boolean findCompraWithClientAndDate(String idClient, Date fecha) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Compra c WHERE c.cliente = :name AND c.fechaDeCompra = :password");
            query.setParameter("name", Integer.parseInt(idClient));
            query.setParameter("password", fecha);
            List<Compra> resultList = query.getResultList();
            if (resultList.size() > 0) {
                return true;
            } else {
                return false;
            }


        } finally {
            em.close();
        }
    }
}
