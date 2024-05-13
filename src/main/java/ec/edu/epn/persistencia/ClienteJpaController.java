package ec.edu.epn.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ec.edu.epn.logica.Cliente;

import java.io.Serializable;
import java.util.List;

public class ClienteJpaController implements Serializable {
    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("GR01_1BT3_622_24A_PU");
        this.emf = emf;
    }

    public void create(Cliente cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(Cliente cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(cliente);
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
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Cliente> findAllClientes() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Cliente c");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public boolean existClientWithNameAndPassword(String name, String password) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre = :name AND c.clave = :password");
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

    public Cliente findClientWithNameAndPassword(String name, String password) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre = :name AND c.clave = :password");
            query.setParameter("name", name);
            query.setParameter("password", password);
            return (Cliente) query.getResultList().get(0);

        } finally {
            em.close();
        }
    }

}
