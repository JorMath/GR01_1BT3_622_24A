package epn.Servlets;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Persistencia.Comprador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/servlet-ejemplo")
public class HelloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Sesion que se crea automáticamente al entrar a la web por el usuario
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Comprador> listaCompradores = entityManager.createQuery("SELECT c.cedula, c.nombre, c.apellido, c.telefono FROM Comprador c", Comprador.class).getResultList();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCompradores", listaCompradores);
        response.sendRedirect("busqueda.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        Comprador comprador = new Comprador(cedula, nombre, apellido, telefono);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(comprador);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        response.sendRedirect("index.jsp");
    }
}
