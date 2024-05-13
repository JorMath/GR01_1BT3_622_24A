package ec.edu.epn.Servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.ControladoraCliente;

@WebServlet(name = "SvCliente", value = "/SvCliente")
public class SvCliente extends HttpServlet {
    ControladoraCliente controladoraCliente = new ControladoraCliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes = controladoraCliente.listarClientes();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaClientes", listaClientes);
        response.sendRedirect("mostrarClientes.jsp");*/
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String clave = request.getParameter("clave");
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setClave(clave);
        controladoraCliente.crearCliente(cliente); //le pasamos a la controladora de la logica, para que despues pase a la de la persistencia y finalmente a la BD
        response.sendRedirect("index.jsp");
    }
}