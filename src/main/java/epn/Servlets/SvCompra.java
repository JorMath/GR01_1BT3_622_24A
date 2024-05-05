package epn.Servlets;

import java.io.*;
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

@WebServlet(name = "SvCompra", value = "/servlet-compra")
public class SvCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idUsuario = 1;
        int idVideojuego = Integer.parseInt(request.getParameter("idVideojuego"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        EntityManager entityManager = ControladorEntidad.getEntityManager("default");
        entityManager.getTransaction().begin();
        entityManager.persist(new Compra(entityManager.find(Videojuego.class, idVideojuego), entityManager.find(Usuario.class, idUsuario), precio));
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        Biblioteca biblioteca = entityManager.find(Biblioteca.class, idUsuario);
        biblioteca.setIdVideojuego(entityManager.find(Videojuego.class, idVideojuego));
        entityManager.getTransaction().commit();
        ControladorEntidad.cerrarEntidad(entityManager);
        response.sendRedirect("busqueda.jsp");
    }
}
