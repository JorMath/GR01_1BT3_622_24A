package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.UsuarioDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class ClienteDTOTest {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Test
    public void given_datos_when_usuario_registra_then_desarrollador_dado_de_alta(){
        //Prueba para observar si registra en la base de datos
        System.out.println("Prueba2");
        Cliente cliente = new Cliente();
        cliente.setNombre("Jorge");
        cliente.setApellido("Zambrano");
        cliente.setClave("1234");
        usuarioDAO.crearCliente(cliente);

        assertTrue(usuarioDAO.existeCliente("Jorge", "Zambrano", "1234"));
    }

    @Test
    public void testCrearCliente() {
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
}
