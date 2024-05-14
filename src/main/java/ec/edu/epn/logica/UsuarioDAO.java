package ec.edu.epn.logica;

import ec.edu.epn.persistencia.DAOPersistencia;

import java.util.List;

public class UsuarioDAO {
    DAOPersistencia daoPersistencia = new DAOPersistencia();
    public void crearCliente(Cliente cliente) {
        daoPersistencia.crearCliente(cliente);
    }
    public void crearDesarrollador(Desarrollador desarrollador) {
        daoPersistencia.crearDesarrollador(desarrollador);
    }

    public List<Cliente> listarClientes() {
        return daoPersistencia.listarClientes();
    }


    public boolean existeUsuario(String nombreEntrante, String claveEntrante, String chkOption) {
        return daoPersistencia.validarClienteExistente(nombreEntrante, claveEntrante, chkOption);
    }

    public int obtenerIdUsuario(String nombreEntrante, String claveEntrante) {
        return daoPersistencia.obtenerIdUsuario(nombreEntrante, claveEntrante);
    }

    public Cliente obtenerCliente(String nombreEntrante, String claveEntrante) {
        return daoPersistencia.obtenerCliente(nombreEntrante, claveEntrante);
    }

    public void crearCompra(Compra compra) {
        daoPersistencia.crearCompra(compra);
    }

    public Desarrollador obtenerDesarrollador(String nombreEntrante, String claveEntrante) {
        return daoPersistencia.obtenerDesarrollador(nombreEntrante, claveEntrante);
    }

    public List<Desarrollador> listarDesarrolladores() {
        return daoPersistencia.obtenerDesarrolladores();
    }

    public boolean existeDesarrollador(String nombre, String apellido, String contra) {
        return daoPersistencia.obtenerDesarrollador(nombre, contra) != null;
    }

    public boolean existeCliente(String nombre, String apellido, String contra) {
        return daoPersistencia.obtenerCliente(nombre, contra) != null;
    }

    public void eliminarDesarrollador(String name, String contraseña) {
        daoPersistencia.eliminarDesarrollador(name, contraseña);
    }

    public void setDAOPersistencia(DAOPersistencia daoPersistencia) {
        this.daoPersistencia = daoPersistencia;
    }
}
