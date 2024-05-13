package ec.edu.epn.Servlets;

import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.ControladoraUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvDesarrollador", value = "/SvDesarrollador")
public class SvDesarrollador extends HttpServlet {
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

        Desarrollador desarrolladorNuevo = new Desarrollador();
        desarrolladorNuevo.setNombre(nombre);
        desarrolladorNuevo.setApellido(apellido);
        desarrolladorNuevo.setClave(clave);
        controladoraUsuario.crearDesarrollador(desarrolladorNuevo);

        response.sendRedirect("index.jsp");

    }


}
