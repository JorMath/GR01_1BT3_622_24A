package ec.edu.epn.Servlets;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.ControladoraUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvUsuario", value = "/SvUsuario")
public class SvUsuario extends HttpServlet {
    ControladoraUsuario controladoraUsuario = new ControladoraUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String clave = request.getParameter("clave");
        Boolean esDev = request.getParameter("chkDesarrollador") == "on"? true: false;
        if (esDev) {
            Desarrollador desarrolladorNuevo = new Desarrollador();
            desarrolladorNuevo.setNombre(nombre);
            desarrolladorNuevo.setApellido(nombre);
            desarrolladorNuevo.setClave(clave);
            controladoraUsuario.crearDesarrollador(desarrolladorNuevo);
            response.sendRedirect("index.jsp");
            return;
            
        }
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setNombre(nombre);
        clienteNuevo.setApellido(apellido);
        clienteNuevo.setClave(clave);
        controladoraUsuario.crearCliente(clienteNuevo);
        response.sendRedirect("index.jsp");
    }

}
