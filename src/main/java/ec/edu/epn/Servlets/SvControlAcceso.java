package ec.edu.epn.Servlets;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.ControladoraCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvControlAcceso", value = "/SvControlAcceso")
public class SvControlAcceso extends HttpServlet {
    ControladoraCliente controladoraCliente = new ControladoraCliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreEntrante = request.getParameter("nombreEntrante");
        String claveEntrante = request.getParameter("clave");
        String chkOption = request.getParameter("chkDesarrollador");

        if(!controladoraCliente.validarIngreso(nombreEntrante, claveEntrante, chkOption)){
            response.sendRedirect("registro.jsp");
        }
        if(esDesarrollador(chkOption)){
            response.sendRedirect("menuDesarrollador.jsp");
        } else {
            response.sendRedirect("catalogo.jsp");
        }

    }

    private boolean esDesarrollador(String chkOption) {
        return chkOption.equals("on");
    }

}