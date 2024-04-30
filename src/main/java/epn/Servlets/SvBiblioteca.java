package epn.Servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Persistencia.Biblioteca;
import Persistencia.Compra;
import Persistencia.Usuario;
import Persistencia.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SvBiblioteca", value = "/servlet-biblioteca")
public class SvBiblioteca extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List lista = new ArrayList<Videojuego>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            lista = entityManager.createQuery(
                    "SELECT v FROM Biblioteca b JOIN Videojuego v on b.idVideojuego = v",
                    Videojuego.class
            ).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            request.getSession().setAttribute("lista", lista);
        response.sendRedirect("biblioteca.jsp");



    }
}
