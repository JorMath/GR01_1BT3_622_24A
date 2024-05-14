package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.Compra;
import ec.edu.epn.logica.Desarrollador;
import ec.edu.epn.logica.Videojuego;

import java.util.List;

public class ControladoraPersistencia {
    ClienteJpaController clienteJPA = new ClienteJpaController();
    DesarrolladorJpaController desarrolladorJpa = new DesarrolladorJpaController();
    VideojuegoJpaController videojuegoJpa = new VideojuegoJpaController();
    CompraJpaController compraJpa = new CompraJpaController();

    //Operacion create Cliente
    public void crearCliente(Cliente cliente) {
        clienteJPA.create(cliente);
    }
    public void crearDesarrollador(Desarrollador desarrollador) {
        desarrolladorJpa.create(desarrollador);
    }

    //Operacion Read
    public List<Cliente> listarClientes() {
        return clienteJPA.findAllClientes();
    }

    //Operacion create Videojuego
    public void crearVideojuego(Videojuego videojuego) {
        videojuegoJpa.create(videojuego);
    }

    //Operacion Read
    public List<Videojuego> listarVideojuegos() {
        return videojuegoJpa.findAllVideojuego();
    }

    //Operacion create Compra
    public void crearCompra(Compra compra) {
        compraJpa.create(compra);
    }

    //Operacion Read
    public List<Compra> listarCompras() {
        return compraJpa.findAllCompras();
    }

    public boolean validarClienteExistente(String nombreEntrante, String claveEntrante, String chkOption) {
        if(chkOption != null && chkOption.equals("on")) {
            return desarrolladorJpa.findDesarrolladorByNameAndPassword(nombreEntrante, claveEntrante);
        }
        return clienteJPA.existClientWithNameAndPassword(nombreEntrante, claveEntrante);
    }

    public int obtenerIdUsuario(String nombreEntrante, String claveEntrante) {
        Cliente cliente = clienteJPA.findClientWithNameAndPassword(nombreEntrante, claveEntrante);
        return cliente.getIdCliente();
    }

    public Cliente obtenerCliente(String nombreEntrante, String claveEntrante) {
        return clienteJPA.findClientWithNameAndPassword(nombreEntrante, claveEntrante);
    }

    public Videojuego obtenerVideojuego(int idVideojuego) {
        return videojuegoJpa.findVideojuego(idVideojuego);
    }

    public Desarrollador obtenerDesarrollador(String nombreEntrante, String claveEntrante) {
        return desarrolladorJpa.obtenerDesarrolladorByNameAndPassword(nombreEntrante, claveEntrante);
    }
}
