package ec.edu.epn.logica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Compra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCompra;

    @Temporal(TemporalType.DATE)
    private Date fechaDeCompra;
    private double precioTotal;
    @ManyToOne
    @JoinColumn(name = "idVideojuego")
    private Videojuego videojuego;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public Compra(int idCompra, Videojuego videojuego, Date fechaDeCompra, Cliente cliente, double precioTotal) {
        this.idCompra = idCompra;
        this.videojuego = videojuego;
        this.fechaDeCompra = fechaDeCompra;
        this.cliente = cliente;
        this.precioTotal = precioTotal;
    }

    public Compra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double calcularCompraConIva() {
        return this.videojuego.getPrecio() * 1.15;
    }
}
