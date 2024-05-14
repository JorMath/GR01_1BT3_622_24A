package ec.edu.epn.Servlets;

import ec.edu.epn.logica.ControladoraUsuario;
import ec.edu.epn.persistencia.ControladoraPersistencia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SvControlRegistro", value = "/SvControlRegistro")
public class SvControlRegistro extends HttpServlet {
    ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String chkOption = request.getParameter("chkDesarrollador");
        if(esDesarrollador(chkOption)){
            SvDesarrollador svDesarrollador = new SvDesarrollador();
            svDesarrollador.doPost(request, response);
        }else{
            SvCliente svCliente = new SvCliente();
            svCliente.doPost(request, response);
        }
    }

    private boolean esDesarrollador(String chkOption) {
        return chkOption != null && chkOption.equals("on");
    }

}