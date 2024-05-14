package ec.edu.epn.Servlets;

import java.io.*;
import java.util.Date;

import ec.edu.epn.logica.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SvCompra", value = "/SvCompra")
public class SvCompra extends HttpServlet {
    ControladoraUsuario controladoraUsuario = new ControladoraUsuario();

    ControladoraVideojuego controladoraVideojuego = new ControladoraVideojuego();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idVideojuego = Integer.parseInt(request.getParameter("idVideojuego"));

        Videojuego videojuego = controladoraVideojuego.obtenerVideojuego(idVideojuego);

        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");

        Date fecha = new Date();

        Compra compra = new Compra();

        compra.setCliente(cliente);
        compra.setVideojuego(videojuego);
        compra.setFechaDeCompra(fecha);

        controladoraUsuario.crearCompra(compra); //le pasamos a la controladora de la logica, para que despues pase a la de la persistencia y finalmente a la BD
        response.sendRedirect("index.jsp");
    }
}