package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.UsuarioDAO;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.Assert.*;

@TestMethodOrder(OrderAnnotation.class)
public class DesarrolladorDTOTest {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    DesarrolladorDTO dto = new DesarrolladorDTO();

    @Test
    @Order(1)
    public void given_datos_when_usuario_registra_then_desarrollador_dado_de_alta(){
        //Prueba para observar si registra en la base de datos
        System.out.println("Prueba1");
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.setNombre("Jorge");
        desarrollador.setApellido("Zambrano");
        desarrollador.setClave("1234");
        desarrollador.setVideojuegos(new ArrayList<>());
        usuarioDAO.crearDesarrollador(desarrollador);
        //desarrolladorDTO.create(desarrollador);

        assertTrue(usuarioDAO.existeDesarrollador("Jorge", "Zambrano", "1234"));
    }

    @Test
    @Order(2)
    public void given_datos_when_usuario_elimina_then_desarrollador_dado_de_baja(){
        System.out.println("Prueba2");
        usuarioDAO.eliminarDesarrollador("Jorge", "1234");

        assertFalse(usuarioDAO.existeDesarrollador("Jorge", "Zambrano", "1234"));
    }

}
