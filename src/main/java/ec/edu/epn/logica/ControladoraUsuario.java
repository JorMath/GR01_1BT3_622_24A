package ec.edu.epn.logica;

import ec.edu.epn.persistencia.ControladoraPersistencia;

import java.util.List;

public class ControladoraCliente {
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
    public void crearCliente(Cliente cliente) {
        controladoraPersistencia.crearCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return controladoraPersistencia.listarClientes();
    }


    public boolean validarIngreso(String nombreEntrante, String claveEntrante, String chkOption) {
        return controladoraPersistencia.validarClienteExistente(nombreEntrante, claveEntrante, chkOption);
    }
}
