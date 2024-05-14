package ec.edu.epn.Servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.UsuarioDAO;

@WebServlet(name = "SvCliente", value = "/SvCliente")
public class SvCliente extends HttpServlet {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        usuarioDAO.crearCliente(new Cliente((request.getParameter("nombre")),request.getParameter("apellido"),
                request.getParameter("clave")));
        response.sendRedirect("index.jsp");
    }
}