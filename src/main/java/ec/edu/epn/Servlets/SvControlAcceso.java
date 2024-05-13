package ec.edu.epn.Servlets;

import ec.edu.epn.logica.ControladoraUsuario;
import ec.edu.epn.logica.Videojuego;
import ec.edu.epn.persistencia.ControladoraPersistencia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvControlAcceso", value = "/SvControlAcceso")
public class SvControlAcceso extends HttpServlet {
    ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreEntrante = request.getParameter("nombreEntrante");
        String claveEntrante = request.getParameter("claveEntrante");
        String chkOption = request.getParameter("chkDesarrollador");

        if(!controladoraUsuario.existeUsuario(nombreEntrante, claveEntrante, chkOption)){
            response.sendRedirect("registro.jsp");
            return;
        }


        HttpSession sesion = request.getSession();


        if(esDesarrollador(chkOption)){
            response.sendRedirect("menuDesarrollador.jsp");
            sesion.setAttribute("desarrollador", controladoraUsuario.obtenerDesarrollador(nombreEntrante, claveEntrante));
            return;
        }

        sesion.setAttribute("idUsuario", controladoraUsuario.obtenerIdUsuario(nombreEntrante, claveEntrante));
        //sesion.setAttribute("cliente", controladoraUsuario.obtenerCliente(nombreEntrante, claveEntrante));

        List<Videojuego> videojuegos = new ArrayList<Videojuego>();
        videojuegos = controladoraPersistencia.listarVideojuegos();
        sesion.setAttribute("videojuegos", videojuegos);
        response.sendRedirect("catalogo.jsp");
    }

    private boolean esDesarrollador(String chkOption) {
        return chkOption != null && chkOption.equals("on");
    }

}