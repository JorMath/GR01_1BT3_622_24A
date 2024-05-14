package ec.edu.epn.Servlets;

import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.Videojuego;
import ec.edu.epn.persistencia.DAOPersistencia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "SvVideojuego", value = "/SvVideojuego")
public class SvVideojuego extends HttpServlet {
    DAOPersistencia daoPersistencia = new DAOPersistencia();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("tituloVideojuego");
        String descripcion = request.getParameter("descripcionVideojuego");
        double precio = Double.parseDouble(request.getParameter("precioVideojuego"));
        Desarrollador desarrollador = (Desarrollador) request.getSession().getAttribute("desarrollador");

        Videojuego videojuego = new Videojuego();
        videojuego.setTitulo(titulo);
        videojuego.setDescripcion(descripcion);
        videojuego.setPrecio(precio);
        videojuego.setDesarrollador(desarrollador);
        daoPersistencia.crearVideojuego(videojuego);
        response.sendRedirect("index.jsp");
    }
}
