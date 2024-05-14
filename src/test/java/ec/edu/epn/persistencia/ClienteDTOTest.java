package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.UsuarioDAO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteDTOTest {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Test
    @Order(1)
    public void given_datos_when_usuario_registra_then_desarrollador_dado_de_alta(){
        //Prueba para observar si registra en la base de datos
        System.out.println("Prueba1");
        Cliente cliente = new Cliente();
        cliente.setNombre("Jorge");
        cliente.setApellido("Zambrano");
        cliente.setClave("1234");
        usuarioDAO.crearCliente(cliente);

        assertTrue(usuarioDAO.existeCliente("Jorge", "Zambrano", "1234"));
    }

    @Test
    @Order(2)
    public void given_datos_when_usuario_elimina_then_desarrollador_dado_de_baja(){
        System.out.println("Prueba2");
        usuarioDAO.eliminarCliente("Jorge","1234");

        assertFalse(usuarioDAO.existeCliente("Jorge", "Zambrano", "1234"));
    }

    @Test
    public void given_datos_when_usuario_registra_then_desarrollador_dado_de_alta_with_mockito() {
        System.out.println("Prueba1 Mockito");
        // Crear un mock de Cliente
        Cliente clienteMock = Mockito.mock(Cliente.class);

        // Crear un mock de DAOPersistencia
        DAOPersistencia daoPersistenciaMock = Mockito.mock(DAOPersistencia.class);

        // Crear una instancia de UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Establecer el mock de DAOPersistencia en UsuarioDAO
        usuarioDAO.setDAOPersistencia(daoPersistenciaMock);

        // Llamar al método que queremos probar
        usuarioDAO.crearCliente(clienteMock);

        // Verificar que el método crearCliente de DAOPersistencia fue llamado con el clienteMock
        Mockito.verify(daoPersistenciaMock).crearCliente(clienteMock);
    }

    @Test
    public void given_datos_and_check_on_when_usuario_existe_then_ingresar_a_catalogo() {
        // Crear mocks
        String nombreEntranteMock = "Jorge";
        String claveEntranteMock = "Zambrano";
        String chkOptionMock = "on";

        DAOPersistencia daoPersistenciaMock = Mockito.mock(DAOPersistencia.class);
        usuarioDAO.setDAOPersistencia(daoPersistenciaMock);

        // Definir el comportamiento del mock
        Mockito.when(daoPersistenciaMock.validarClienteExistente(nombreEntranteMock, claveEntranteMock, chkOptionMock)).thenReturn(true);

        // Llamar al método que queremos probar
        boolean existe = usuarioDAO.existeUsuario(nombreEntranteMock, claveEntranteMock, chkOptionMock);

        // Verificar el resultado
        assert(existe);

        // Verificar que el método validarClienteExistente de DAOPersistencia fue llamado con los argumentos correctos
        Mockito.verify(daoPersistenciaMock).validarClienteExistente(nombreEntranteMock, claveEntranteMock, chkOptionMock);
    }
}
