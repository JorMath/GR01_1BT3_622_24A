package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.UsuarioDAO;
import ec.edu.epn.logica.Videojuego;
import ec.edu.epn.logica.VideojuegoDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
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

    @Test
    @Order(2)
    public void given_datos_when_usuario_elimina_then_videojuego_dado_de_baja(){
        System.out.println("Prueba2");
        videojuegoDAO.eliminarVideojuego("GTA V");

        assertFalse(videojuegoDAO.existeVideojuego("GTA V"));
    }
}
