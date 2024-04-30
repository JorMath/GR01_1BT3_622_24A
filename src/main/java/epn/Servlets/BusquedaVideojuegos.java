package epn.Servlets;

import Persistencia.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public  class BusquedaVideojuegos {

    public BusquedaVideojuegos() {

    }
    public List filtrarBusqueda(String titulo){
        List lista = new ArrayList<Videojuego>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if(titulo.equals("")){
            lista = entityManager.createQuery("SELECT v FROM Videojuego v", Videojuego.class).getResultList();
        }
        else {
            lista = entityManager.createQuery("SELECT v from Videojuego v where v.titulo like '%"+titulo+"%'", Videojuego.class).getResultList();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return lista;
    }
}
