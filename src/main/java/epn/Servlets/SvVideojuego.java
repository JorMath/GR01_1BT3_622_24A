package epn.Servlets;

import Persistencia.Videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SvVideojuego", value = "/servlet-busqueda")
public class SvVideojuego extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Sesion que se crea automáticamente al entrar a la web por el usuario

        BusquedaVideojuegos busquedaVideojuegos = new BusquedaVideojuegos();
        List<Videojuego> listaVideojuegos = busquedaVideojuegos.filtrarBusqueda(request.getParameter("titulo"));
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaVideojuegos", listaVideojuegos);
        response.sendRedirect("resultado.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //volver
        response.sendRedirect("busqueda.jsp");
    }

}
