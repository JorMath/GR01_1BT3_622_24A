package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.UsuarioDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class UsuarioDAOParametersTest {
    UsuarioDAO usuarioDAO;
    @Parameterized.Parameters
    public static List<Object[]> parameters(){
        List <Object[]> objects = new ArrayList<Object[]>();
        objects.add(crearUserDAO("Jorge", "Papas", "1452"));
        objects.add(crearUserDAO("David", "Jose", "2541"));
        objects.add(crearUserDAO("Pepa", "Pedro", "5623"));
        objects.add(crearUserDAO("Pig", "Andrade", "4785"));
        objects.add(crearUserDAO("Roberto", "Pedro", "9658"));
        return objects;
    }

    private static Object[] crearUserDAO(String nombre, String apellido, String clave) {
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.setNombre(nombre);
        desarrollador.setApellido(apellido);
        desarrollador.setClave(clave);
        desarrollador.setVideojuegos(new ArrayList<>());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.crearDesarrollador(desarrollador);
        return new UsuarioDAO[]{usuarioDAO};
    }

    public UsuarioDAOParametersTest(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Test
    public void given_data_when_user_register_then_dev_has_been_registered(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        //Prueba para observar si registra en la base de datos
        System.out.println("Prueba Parametrizada para registrar un desarrollador");
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.setNombre("Jorge");
        desarrollador.setApellido("Zambrano");
        desarrollador.setClave("1234");
        desarrollador.setVideojuegos(new ArrayList<>());
        usuarioDAO.crearDesarrollador(desarrollador);
        //desarrolladorDTO.create(desarrollador);

        assertTrue(usuarioDAO.existeDesarrollador("Jorge", "Zambrano", "1234"));
    }
}