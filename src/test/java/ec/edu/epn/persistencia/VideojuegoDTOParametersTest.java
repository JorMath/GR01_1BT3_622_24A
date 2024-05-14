package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.UsuarioDAO;
import ec.edu.epn.logica.Videojuego;
import ec.edu.epn.logica.VideojuegoDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class VideojuegoDTOParametersTest {
    VideojuegoDAO videojuegoDAO;

    public VideojuegoDTOParametersTest(VideojuegoDAO videojuegoDAO) {
        this.videojuegoDAO = videojuegoDAO;
    }

    @Parameterized.Parameters
    public static List<Object[]> parameters(){
        List <Object[]> objects = new ArrayList<Object[]>();
        objects.add(videojuegoDAO("Roblox", 50, "1452"));
        objects.add(videojuegoDAO("COD2", 45, "2541"));
        objects.add(videojuegoDAO("BatleFront", 78, "5623"));
        objects.add(videojuegoDAO("Squadroons", 32, "4785"));
        objects.add(videojuegoDAO("Fallen Order", 61, "9658"));
        return objects;
    }

    public static Object[] videojuegoDAO(String titulo, Integer precio, String descripcion) {
        DesarrolladorDTO desarrolladorDTO = new DesarrolladorDTO();
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        Videojuego videojuego = new Videojuego();
        videojuego.setDesarrollador(desarrolladorDTO.obtenerDesarrolladorByNameAndPassword("Jorge", "1234"));
        videojuego.setTitulo(titulo);
        videojuego.setPrecio(precio);
        videojuego.setDescripcion(descripcion);
        videojuegoDAO.crearVideojuego(videojuego);
        return new VideojuegoDAO[]{videojuegoDAO};
    }


    @Test
    public void given_data_when_videogames_then_dev_has_been_registered(){
        //Prueba para observar si registra en la base de datos
        DesarrolladorDTO desarrolladorDTO = new DesarrolladorDTO();
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        System.out.println("Prueba videojuego existe");
        Videojuego videojuego = new Videojuego();
        videojuego.setDesarrollador(desarrolladorDTO.obtenerDesarrolladorByNameAndPassword("Jorge", "1234"));
        videojuego.setTitulo("GTA V");
        videojuego.setPrecio(54);
        videojuego.setDescripcion("Este es el nuevo GTA V para PS6");
        videojuegoDAO.crearVideojuego(videojuego);

        assertTrue(videojuegoDAO.obtenerVideojuegoPorNombre("GTA V"));

    }
    @Before
    public void setUpDesarrollador(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("Prueba previa (necesaria)");
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.setNombre("Jorge");
        desarrollador.setApellido("Zambrano");
        desarrollador.setClave("1234");
        desarrollador.setVideojuegos(new ArrayList<>());
        usuarioDAO.crearDesarrollador(desarrollador);

        //assertTrue(usuarioDAO.existeDesarrollador("Jorge", "Zambrano", "1234"));

    }
}