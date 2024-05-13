package ec.edu.epn.persistencia;

import ec.edu.epn.logica.Cliente;
import ec.edu.epn.logica.Compra;
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
        if(chkOption.equals("on")) {
            return desarrolladorJpa.findClienteByNameAndPassword(nombreEntrante, claveEntrante);
        }
        return clienteJPA.findClienteByNameAndPassword(nombreEntrante, claveEntrante);
    }
}
