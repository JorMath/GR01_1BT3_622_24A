package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.UsuarioDAO;
import ec.edu.epn.logica.Videojuego;
import ec.edu.epn.logica.VideojuegoDAO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class VideojuegoDTOTest {
    VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
    DesarrolladorDTO desarrolladorDTO = new DesarrolladorDTO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();


    @Before
    public void setUpDesarrollador(){
        System.out.println("Prueba previa (necesaria)");
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.setNombre("Jorge");
        desarrollador.setApellido("Zambrano");
        desarrollador.setClave("1234");
        desarrollador.setVideojuegos(new ArrayList<>());
        usuarioDAO.crearDesarrollador(desarrollador);

        assertTrue(usuarioDAO.existeDesarrollador("Jorge", "Zambrano", "1234"));
    }

    @Test
    public void given_datos_when_desarrollador_registra_then_videojuego_dado_de_alta(){
        //Prueba para observar si registra en la base de datos
        System.out.println("Prueba videojuego existe");
        Videojuego videojuego = new Videojuego();
        videojuego.setDesarrollador(desarrolladorDTO.obtenerDesarrolladorByNameAndPassword("Jorge", "1234"));
        videojuego.setTitulo("GTA V");
        videojuego.setPrecio(54);
        videojuego.setDescripcion("Este es el nuevo GTA V para PS6");
        videojuegoDAO.crearVideojuego(videojuego);

        assertTrue(videojuegoDAO.obtenerVideojuegoPorNombre("GTA V"));
    }
}
