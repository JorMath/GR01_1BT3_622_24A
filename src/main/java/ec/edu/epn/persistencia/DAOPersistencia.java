package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.Compra;
import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.Videojuego;

import java.util.List;

public class DAOPersistencia {
    ClienteDTO clienteDTO = new ClienteDTO();
    DesarrolladorDTO desarrolladorDTO = new DesarrolladorDTO();
    VideojuegoDTO videojuegoDTO = new VideojuegoDTO();
    CompraDTO compraDTO = new CompraDTO();

    //Operacion create Cliente
    public void crearCliente(Cliente cliente) {
        clienteDTO.create(cliente);
    }
    public void crearDesarrollador(Desarrollador desarrollador) {
        desarrolladorDTO.create(desarrollador);
    }

    //Operacion Read
    public List<Cliente> listarClientes() {
        return clienteDTO.findAllClientes();
    }

    //Operacion create Videojuego
    public void crearVideojuego(Videojuego videojuego) {
        videojuegoDTO.create(videojuego);
    }

    //Operacion Read
    public List<Videojuego> listarVideojuegos() {
        return videojuegoDTO.findAllVideojuego();
    }

    //Operacion create Compra
    public void crearCompra(Compra compra) {
        compraDTO.create(compra);
    }

    //Operacion Read
    public List<Compra> listarCompras() {
        return compraDTO.findAllCompras();
    }

    public boolean validarClienteExistente(String nombreEntrante, String claveEntrante, String chkOption) {
        if(chkOption != null && chkOption.equals("on")) {
            return desarrolladorDTO.existDesarrolladorByNameAndPassword(nombreEntrante, claveEntrante);
        }
        return clienteDTO.existClientWithNameAndPassword(nombreEntrante, claveEntrante);
    }

    public int obtenerIdUsuario(String nombreEntrante, String claveEntrante) {
        Cliente cliente = clienteDTO.findClientWithNameAndPassword(nombreEntrante, claveEntrante);
        return cliente.getIdCliente();
    }

    public Cliente obtenerCliente(String nombreEntrante, String claveEntrante) {
        return clienteDTO.findClientWithNameAndPassword(nombreEntrante, claveEntrante);
    }

    public Videojuego obtenerVideojuego(int idVideojuego) {
        return videojuegoDTO.findVideojuego(idVideojuego);
    }

    public Desarrollador obtenerDesarrollador(String nombreEntrante, String claveEntrante) {
        return desarrolladorDTO.obtenerDesarrolladorByNameAndPassword(nombreEntrante, claveEntrante);
    }

    public List<Desarrollador> obtenerDesarrolladores() {
        return desarrolladorDTO.obtenerTodosLosDesarrolladores();
    }

    public boolean obtenerVideojuego(String tituloABuscar) {
        return videojuegoDTO.findVideojuegoByName(tituloABuscar);
    }

    public void eliminarCliente(int idCliente) {
        clienteDTO.delete(idCliente);
    }

    public void eliminarDesarrollador(String name, String contraseña) {
        System.out.println(obtenerDesarrollador(name,contraseña).getIdDesarrollador());
        desarrolladorDTO.delete(obtenerDesarrollador(name,contraseña).getIdDesarrollador());
    }
}
