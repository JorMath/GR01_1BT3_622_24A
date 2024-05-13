package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.Desarrollador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

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
            // Obtener los resultados
            List<Desarrollador> resultados = query.getResultList();

            for (Desarrollador desarrollador : resultados) {
                System.out.println("Nombre: " + desarrollador.getNombre() + "|||||"+ name);
                System.out.println("Clave: " + desarrollador.getClave()+ "|||||"+ password);
            }
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
}
