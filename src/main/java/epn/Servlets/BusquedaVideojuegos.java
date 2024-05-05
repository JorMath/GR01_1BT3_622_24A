package epn.Servlets;

import Persistencia.Videojuego;
import jakarta.persistence.EntityManager;


import java.util.List;
public  class BusquedaVideojuegos {

    public BusquedaVideojuegos() {

    }
    public List filtrarBusqueda(String titulo){
        EntityManager entityManager = ControladorEntidad.getEntityManager("default");
        try {
            entityManager.getTransaction().begin();
            return buscarVideojuegoPorTitulo(titulo, entityManager);
        } finally {
            ControladorEntidad.cerrarEntidad(entityManager);
        }
    }
    public List<Videojuego> buscarVideojuegoPorTitulo(String titulo, EntityManager entityManager){
        return titulo.equals("") ? buscarTodosLosVideojuegos(entityManager) : buscarVideojuegosPorCoincidencia(entityManager, titulo);
    }

    private List<Videojuego> buscarTodosLosVideojuegos(EntityManager entityManager) {
        return entityManager.createQuery("SELECT v FROM Videojuego v", Videojuego.class).getResultList();
    }

    private List<Videojuego> buscarVideojuegosPorCoincidencia(EntityManager entityManager, String titulo) {
        return entityManager.createQuery("SELECT v from Videojuego v where v.titulo like '%" + titulo + "%'", Videojuego.class).getResultList();
    }

    public static List<Videojuego> obtenerVideojuegosBiblioteca(EntityManager entityManager) {
        return entityManager.createQuery(
                "SELECT v FROM Biblioteca b JOIN Videojuego v on b.idVideojuego = v",
                Videojuego.class
        ).getResultList();
    }
}

