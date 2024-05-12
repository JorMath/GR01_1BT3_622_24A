package Persistencia;

import logica.Cliente;
import logica.Compra;
import logica.Videojuego;

import java.util.List;

public class ControladoraPersistencia {
    ClienteJpaController clienteJPA = new ClienteJpaController();
    VideojuegoJpaController videojuegoJpa = new VideojuegoJpaController();
    CompraJpaController compraJpa = new CompraJpaController();

    //Operacion create Cliente
    public void crearCliente(Cliente cliente) {
        clienteJPA.create(cliente);
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


}
