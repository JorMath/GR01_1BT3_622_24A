package logica;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Compra {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCompra;

    private Date fechaDeCompra;
    @ManyToOne
    @JoinColumn(name = "idVideojuego")
    private Videojuego videojuego;

    public Compra(int idCompra, Videojuego videojuego, Date fechaDeCompra) {
        this.idCompra = idCompra;
        this.videojuego = videojuego;
        this.fechaDeCompra = fechaDeCompra;
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
}
