package ec.edu.epn.servlets;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.ControladoraCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "svcontrolAcceso", value = "/svcontrolAcceso")
public class svcontrolAcceso extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String menuOption = request.getParameter("chkDesarrollador");
        if(menuOption != null && menuOption.equals("on")) {
            response.sendRedirect("menuDesarrollar.jsp");
        } else {
            response.sendRedirect("menuVideojuego.jsp");
        }
    }
}