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
        EntityManager entityManager = ControladorEntidad.getEntityManager("default");
        entityManager.getTransaction().begin();
        request.getSession().setAttribute("lista", BusquedaVideojuegos.obtenerVideojuegosBiblioteca(entityManager));
        ControladorEntidad.cerrarEntidad(entityManager);
        response.sendRedirect("biblioteca.jsp");
    }
}
