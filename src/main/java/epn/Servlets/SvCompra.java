package epn.Servlets;

import java.io.*;
import java.util.List;

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
        Compra compra = new Compra(idVideojuego, idUsuario, precio);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(compra);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        response.sendRedirect("busqueda.jsp");
    }
}